package com.ranim.product.service;

import com.ranim.product.dto.APIResponseDto;

public interface ProductService {
    APIResponseDto getProductById(Long id);
}
