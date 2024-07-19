package com.fsse2406.project.data.cart.domainObject;

import com.fsse2406.project.data.cart.entity.CartItemEntity;

import java.math.BigDecimal;

public class CartItemResponseData {

    private Integer pid;
    private Integer quantity;
    private String imageUrl;
    private int stock;
    private String name;
    private BigDecimal price;

    public CartItemResponseData(CartItemEntity entity){

        this.pid = entity.getProduct().getPid();
        this.quantity = entity.getQuantity();
        this.imageUrl = entity.getProduct().getImageUrl();
        this.stock = entity.getProduct().getStock();
        this.name = entity.getProduct().getName();
        this.price = entity.getProduct().getPrice();
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
