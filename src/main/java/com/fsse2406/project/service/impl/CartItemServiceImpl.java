package com.fsse2406.project.service.impl;

import com.fsse2406.project.data.cart.domainObject.CartItemResponseData;
import com.fsse2406.project.data.cart.entity.CartItemEntity;
import com.fsse2406.project.data.product.entity.ProductEntity;
import com.fsse2406.project.data.user.domainObject.FirebaseUserData;
import com.fsse2406.project.data.user.entity.UserEntity;
import com.fsse2406.project.exception.cartItem.CartItemException;
import com.fsse2406.project.exception.cartItem.NoCartItemException;
import com.fsse2406.project.repository.CartItemRepository;
import com.fsse2406.project.service.CartItemService;
import com.fsse2406.project.service.ProductService;
import com.fsse2406.project.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartItemServiceImpl implements CartItemService {
    private static final Logger logger = LoggerFactory.getLogger(CartItemServiceImpl.class);

    private final UserService userService;

    private final ProductService productService;

    private final CartItemRepository cartItemRepository;

    @Autowired
    public CartItemServiceImpl(UserService userService, ProductService productService, CartItemRepository cartItemRepository) {
        this.productService = productService;
        this.userService = userService;
        this.cartItemRepository = cartItemRepository;
    }

    @Override
    public boolean addItemToCart(Integer pid, Integer quantity, FirebaseUserData firebaseUserData) {
//        UserEntity userEntity = userService.getEntityByFirebaseUserData(firebaseUserData);
//
//        List<CartItemResponseData> cartItemResponseDataList = new ArrayList<>();
//
//        ProductEntity product = productService.getEntityByPid(pid);
//        if (cartItemRepository.existsById(pid)){
//            Optional<CartItemEntity>optionalCartItemEntity = cartItemRepository.findById(pid);
//            optionalCartItemEntity.get().setQuantity(optionalCartItemEntity.get().getQuantity() +quantity);
//            cartItemRepository.save(optionalCartItemEntity.get());
//            CartItemResponseData cartItemResponseData = new CartItemResponseData(optionalCartItemEntity.get());
//            cartItemResponseDataList.add(cartItemResponseData);
//            return cartItemResponseDataList;
//        }
//        CartItemEntity cartItemEntity = new CartItemEntity(userEntity, product, quantity);
//        CartItemResponseData cartItemResponseData = new CartItemResponseData(cartItemEntity);
//        cartItemRepository.save(cartItemEntity);
//        cartItemResponseDataList.add(cartItemResponseData);
//        return cartItemResponseDataList;

        try {
            UserEntity userEntity = userService.getEntityByFirebaseUserData(firebaseUserData);
            ProductEntity product = productService.getEntityByPid(pid);

//            if (quantity <= 0) {
//                throw new CartItemException("Quantity must be greater than zero");
//            }

            Optional<CartItemEntity> optionalCartItemEntity = cartItemRepository.findByProductAndUser(product, userEntity);
            if (optionalCartItemEntity.isEmpty()) {
                validateQuantity(quantity, product.getStock());
                CartItemEntity cartItemEntity = new CartItemEntity(userEntity, product, quantity);
                cartItemRepository.save(cartItemEntity);

            } else {
                CartItemEntity cartItemEntity = optionalCartItemEntity.get();
                cartItemEntity.setQuantity(cartItemEntity.getQuantity() + quantity);
                validateQuantity(cartItemEntity.getQuantity(), product.getStock());
                cartItemRepository.save(cartItemEntity);
            }

        } catch (Exception ex) {
            logger.warn("Put CartItem failed: " + ex.getMessage());
            throw ex;
        }
        return true;
    }

    @Override
    public List<CartItemResponseData> getUserCartItems(FirebaseUserData firebaseUserData) {
        List<CartItemEntity> cartItemEntityList = new ArrayList<>();
        List<CartItemResponseData> cartItemResponseDataList = new ArrayList<>();

        try {
            UserEntity userEntity = userService.getEntityByFirebaseUserData(firebaseUserData);

            cartItemEntityList = cartItemRepository.findAllByUser_Uid(userEntity.getUid());
            if (cartItemEntityList.isEmpty()) {
                throw new NoCartItemException("No cart Item");
            }

            for (CartItemEntity cartItemEntity : cartItemEntityList) {

                cartItemResponseDataList.add(new CartItemResponseData(cartItemEntity));
            }
        }catch(Exception ex){
            logger.warn("Get User Cart: " + ex.getMessage());
            throw ex;
        }

        return cartItemResponseDataList;
    }

    public void validateQuantity (Integer quantity, Integer stock){
        if (quantity > stock) {
            throw new CartItemException("Quantity must be smaller than stock");
        }
    }
}

