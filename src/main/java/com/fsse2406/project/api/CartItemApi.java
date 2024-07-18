package com.fsse2406.project.api;

import com.fsse2406.project.data.user.domainObject.FirebaseUserData;
import com.fsse2406.project.service.CartItemService;

import com.fsse2406.project.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class CartItemApi {
    private final CartItemService cartItemService;

    @Autowired
    public CartItemApi(CartItemService cartItemService) {
        this.cartItemService = cartItemService;
    }

    @PutMapping("/{pid}/{quantity}")
    public String addItemToCart(JwtAuthenticationToken jwt,
                                @PathVariable Integer pid,
                                @PathVariable int quantity) {
        FirebaseUserData firebaseUserData = JwtUtil.getFirebaseUserData(jwt);
        cartItemService.addItemToCart(pid , quantity , firebaseUserData);
        return "success";
    }
}
