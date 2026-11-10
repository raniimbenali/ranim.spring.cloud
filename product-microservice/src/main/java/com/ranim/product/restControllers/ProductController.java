package com.ranim.product.restControllers;

import com.ranim.product.dto.APIResponseDto;
import com.ranim.product.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductController {

    private ProductService productService;

    @GetMapping("{id}")
    public ResponseEntity<APIResponseDto> getProductById(@PathVariable("id") Long id) {
        return new ResponseEntity<APIResponseDto>(
                productService.getProductById(id), HttpStatus.OK);
    }
}
