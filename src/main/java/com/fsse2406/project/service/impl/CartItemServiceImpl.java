package com.fsse2406.project.service.impl;

import com.fsse2406.project.data.cart.domainObject.CartItemResponseData;
import com.fsse2406.project.data.cart.entity.CartItemEntity;
import com.fsse2406.project.data.product.entity.ProductEntity;
import com.fsse2406.project.data.user.domainObject.FirebaseUserData;
import com.fsse2406.project.data.user.entity.UserEntity;
import com.fsse2406.project.repository.CartItemRepository;
import com.fsse2406.project.service.CartItemService;
import com.fsse2406.project.service.ProductService;
import com.fsse2406.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartItemServiceImpl implements CartItemService {
    private final UserService userService;

    private final ProductService productService;

    private final CartItemRepository cartItemRepository;

    @Autowired
    public CartItemServiceImpl (UserService userService,ProductService productService,CartItemRepository cartItemRepository) {
        this.productService = productService;
        this.userService = userService;
        this.cartItemRepository = cartItemRepository;
    }

    @Override
    public  List<CartItemResponseData> addItemToCart(Integer pid, Integer quantity, FirebaseUserData firebaseUserData){
        UserEntity userEntity = userService.getEntityByFirebaseUserData(firebaseUserData);

        List<CartItemResponseData> cartItemResponseDataList = new ArrayList<>();

        ProductEntity product = productService.getEntityByPid(pid);
        if (cartItemRepository.existsById(pid)){
            Optional<CartItemEntity>optionalCartItemEntity = cartItemRepository.findById(pid);
            optionalCartItemEntity.get().setQuantity(optionalCartItemEntity.get().getQuantity() +quantity);
            cartItemRepository.save(optionalCartItemEntity.get());
            CartItemResponseData cartItemResponseData = new CartItemResponseData(optionalCartItemEntity.get());
            cartItemResponseDataList.add(cartItemResponseData);
            return cartItemResponseDataList;
        }
        CartItemEntity cartItemEntity = new CartItemEntity(userEntity, product, quantity);
        CartItemResponseData cartItemResponseData = new CartItemResponseData(cartItemEntity);
        cartItemRepository.save(cartItemEntity);
        cartItemResponseDataList.add(cartItemResponseData);
        return cartItemResponseDataList;
    }


}
