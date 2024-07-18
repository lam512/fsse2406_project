package com.fsse2406.project.data.cart.entity;


import com.fsse2406.project.data.product.entity.ProductEntity;
import com.fsse2406.project.data.user.entity.UserEntity;
import jakarta.persistence.*;

@Entity
@Table(name="cartItem")
public class CartItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cid;

    private Integer quantity;

    @ManyToOne
    @JoinColumn(name="user_uid", referencedColumnName = "uid",nullable = false)
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name="product_pid", referencedColumnName = "pid",nullable = false)
    private ProductEntity product;


    public CartItemEntity() {
    }

    public CartItemEntity(UserEntity userEntity, ProductEntity productEntity, Integer quantity){
        this.user = userEntity;
        this.product = productEntity;
        this.quantity = quantity;
    }


    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }
}
