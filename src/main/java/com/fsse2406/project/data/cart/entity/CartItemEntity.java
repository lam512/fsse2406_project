package com.fsse2406.project.data.cart.entity;


import jakarta.persistence.*;

@Entity
@Table(name="cartItem")
public class CartItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cid;

    private Integer pid;
    private Integer uid;
    private Integer quantity;

    public CartItemEntity() {
    }

    public CartItemEntity(Integer uid, Integer pid, Integer quantity){
        this.uid = uid;
        this.pid = pid;
        this.quantity = quantity;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

}
