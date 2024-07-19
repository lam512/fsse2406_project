package com.fsse2406.project.data.cart.dto;

import com.fsse2406.project.data.cart.domainObject.CartItemResponseData;

public class SuccessResponseDto {
    private String result;

    public SuccessResponseDto(){
        setResult("success");
    }

    public String getResult() {
        return result;
    }

    private void setResult(String result) {
        this.result = result;
    }

}
