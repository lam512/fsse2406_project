package com.fsse2406.project.repository;

import com.fsse2406.project.data.cart.entity.CartItemEntity;
import org.springframework.data.repository.CrudRepository;



public interface CartItemRepository extends CrudRepository< CartItemEntity,Integer> {

}
