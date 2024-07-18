package com.fsse2406.project.data.cart.domainObject;

import com.fsse2406.project.data.cart.entity.CartItemEntity;

public class CartItemResponseData {
    private Integer uid;
    private Integer pid;
    private Integer quantity;

    public CartItemResponseData(CartItemEntity entity){
        this.pid = entity.getPid();
        this.quantity = entity.getQuantity();

    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

}
