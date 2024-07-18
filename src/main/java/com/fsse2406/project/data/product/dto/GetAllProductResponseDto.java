package com.fsse2406.project.data.product.dto;

import com.fsse2406.project.data.product.domainObject.ProductResponseData;

import java.math.BigDecimal;

public class GetAllProductResponseDto {
    private Integer pid;
    private String name;
    private String imageUrl;
    private BigDecimal price;
    private boolean hasStock ;

    public GetAllProductResponseDto (ProductResponseData data){
        this.pid = data.getPid();
        this.name = data.getName();
        this.imageUrl = data.getImage_url();
        this.price = data.getPrice();
        this.hasStock = data.getStock()>0 ;
    }

    public Integer getPid() {
        return pid;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public boolean isHasStock() {
        return hasStock;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setHasStock(boolean hasStock) {
        this.hasStock = hasStock;
    }

}
