package com.fsse2406.project.service;

import com.fsse2406.project.data.product.domainObject.ProductResponseData;
import com.fsse2406.project.data.product.entity.ProductEntity;

import java.util.List;

public interface ProductService {

    List<ProductResponseData> getAllProduct();

    ProductResponseData getByProductId(Integer pid);

    ProductEntity getEntityByPid(Integer pid);
}
