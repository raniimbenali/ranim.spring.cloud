package com.ranim.product.service;

import com.ranim.product.dto.APIResponseDto;
import com.ranim.product.dto.BrandDto;
import com.ranim.product.dto.ProductDto;
import com.ranim.product.entities.Product;
import com.ranim.product.repos.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    private APIClient apiClient;

    @Override
    public APIResponseDto getProductById(Long id) {
        Product product = productRepository.findById(id).get();

        BrandDto brandDto = apiClient.getBrandByName(product.getBrand());

        ProductDto productDto = new ProductDto(
                product.getId(),
                product.getName(),
                product.getBrand(),
                product.getCategory(),
                product.getPrice(),
                brandDto.getCountry()
        );

        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setProductDto(productDto);
        apiResponseDto.setBrandDto(brandDto);

        return apiResponseDto;
    }
}
