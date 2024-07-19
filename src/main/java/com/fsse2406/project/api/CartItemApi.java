package com.fsse2406.project.api;

import com.fsse2406.project.data.cart.domainObject.CartItemResponseData;
import com.fsse2406.project.data.cart.dto.CartItemResponseDto;
import com.fsse2406.project.data.cart.dto.SuccessResponseDto;
import com.fsse2406.project.data.user.domainObject.FirebaseUserData;
import com.fsse2406.project.service.CartItemService;

import com.fsse2406.project.util.JwtUtil;
import jakarta.validation.constraints.Positive;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartItemApi {

    private final CartItemService cartItemService;

    @Autowired
    public CartItemApi(CartItemService cartItemService) {
        this.cartItemService = cartItemService;
    }

    @PutMapping("/{pid}/{quantity}")
    public SuccessResponseDto addItemToCart(JwtAuthenticationToken jwt,
                                @PathVariable Integer pid,
                                @Positive @PathVariable int quantity) {
        FirebaseUserData firebaseUserData = JwtUtil.getFirebaseUserData(jwt);
        cartItemService.addItemToCart(pid , quantity , firebaseUserData);
        return new SuccessResponseDto();
    }

    @GetMapping
    public List<CartItemResponseDto> getUserCartItems (JwtAuthenticationToken jwt){
        FirebaseUserData firebaseUserData = JwtUtil.getFirebaseUserData(jwt);
        List<CartItemResponseData> cartItemResponseDataList = cartItemService.getUserCartItems(firebaseUserData);
        List<CartItemResponseDto> cartItemResponseDtoList =new ArrayList<>();
        for (CartItemResponseData cartItemResponseData : cartItemResponseDataList){
            CartItemResponseDto cartItemResponseDto = new CartItemResponseDto(cartItemResponseData);
            cartItemResponseDtoList.add(cartItemResponseDto);
        }
        return cartItemResponseDtoList;
    }
}
