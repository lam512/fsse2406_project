package com.fsse2406.project.data.product.dto;

import com.fsse2406.project.data.product.domainObject.ProductResponseData;

import java.math.BigDecimal;

public class ProductResponseDto {
    private Integer pid;
    private String name;
    private String description;
    private String image_url;
    private BigDecimal price;
    private int stock;

    public ProductResponseDto(ProductResponseData data) {
        this.pid = data.getPid();
        this.name = data.getName();
        this.description = data.getDescription();
        this.image_url = data.getImage_url();
        this.price = data.getPrice();
        this.stock = data.getStock();
    }

    public Integer getPid() {
        return pid;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImage_url() {
        return image_url;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
