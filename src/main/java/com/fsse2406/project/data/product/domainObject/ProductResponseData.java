package com.fsse2406.project.data.product.domainObject;

import com.fsse2406.project.data.product.entity.ProductEntity;
import java.math.BigDecimal;

public class ProductResponseData {

    private Integer pid;
    private String name;
    private String description;
    private String imageUrl;
    private BigDecimal price;
    private int stock;

    public ProductResponseData(ProductEntity entity){
        this.pid = entity.getPid();
        this.name = entity.getName();
        this.description = entity.getDescription();
        this.imageUrl = entity.getImageUrl();
        this.price = entity.getPrice();
        this.stock = entity.getStock();
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
        return imageUrl;
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
        this.imageUrl = image_url;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
