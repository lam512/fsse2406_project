package com.fsse2406.project.service.impl;

import com.fsse2406.project.data.product.domainObject.ProductResponseData;
import com.fsse2406.project.data.product.entity.ProductEntity;
import com.fsse2406.project.exception.product.ProductNotFoundException;
import com.fsse2406.project.repository.ProductRepository;
import com.fsse2406.project.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);


    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductResponseData> getAllProduct() {
        List<ProductResponseData> productResponseDataList = new ArrayList<>();

        for (ProductEntity productEntity : productRepository.findAll()) {
            ProductResponseData productResponseData = new ProductResponseData(productEntity);
            productResponseDataList.add(productResponseData);
        }
        return productResponseDataList;
    }

    @Override
    public ProductResponseData getByProductId(Integer pid) {
        try {
            return new ProductResponseData(getEntityByPid(pid));
        } catch (Exception ex) {
            logger.warn("Get Product By Pid: " + ex.getMessage());
            throw ex;
        }
    }

    @Override
    public ProductEntity getEntityByPid (Integer pid){
        return productRepository.findById(pid).orElseThrow(
        ()-> new ProductNotFoundException(pid)
        );
    }
}

