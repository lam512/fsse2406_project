package com.fsse2406.project.service;


import com.fsse2406.project.data.cart.domainObject.CartItemResponseData;
import com.fsse2406.project.data.user.domainObject.FirebaseUserData;

import java.util.List;

public interface CartItemService {
    List<CartItemResponseData> addItemToCart(Integer pid, Integer quantity, FirebaseUserData firebaseUserData);

}
