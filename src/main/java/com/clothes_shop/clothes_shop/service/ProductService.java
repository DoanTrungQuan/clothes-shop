package com.clothes_shop.clothes_shop.service;

import com.clothes_shop.clothes_shop.domain.Product;
import com.clothes_shop.clothes_shop.dto.ProductDto;

import java.util.List;

public interface ProductService {
    Product getProductById(Long id);
    List<Product> getAllProducts();
    String deleteProduct(Long id);
    Product updateProduct(Long id, ProductDto dto);
    Product addProduct(ProductDto dto);

}
