package com.fsse2406.project.api;

import com.fsse2406.project.data.product.domainObject.ProductResponseData;
import com.fsse2406.project.data.product.dto.GetAllProductResponseDto;
import com.fsse2406.project.data.product.dto.ProductResponseDto;
import com.fsse2406.project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductApi {

    private final ProductService productService;

    @Autowired
    public ProductApi (ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/public/product")
    public List<GetAllProductResponseDto> getAllPeople(){
        List<ProductResponseData> productResponseDataList = productService.getAllProduct();

        List<GetAllProductResponseDto> getAllProductResponseDtoList = new ArrayList<>();
        for (ProductResponseData productResponseData : productResponseDataList){
            GetAllProductResponseDto getAllProductResponseDto = new GetAllProductResponseDto(productResponseData);
            getAllProductResponseDtoList.add(getAllProductResponseDto);
        }
        return getAllProductResponseDtoList;
    }

    @GetMapping("/public/product/{pid}")
    public ProductResponseDto getByPid (@PathVariable Integer pid) {
        ProductResponseData productResponseData = productService.getByProductId(pid);
        ProductResponseDto productResponseDto = new ProductResponseDto(productResponseData);
        return productResponseDto;
    }

}
