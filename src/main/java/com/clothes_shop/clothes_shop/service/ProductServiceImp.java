package com.clothes_shop.clothes_shop.service;

import com.clothes_shop.clothes_shop.common.EError;
import com.clothes_shop.clothes_shop.domain.Product;
import com.clothes_shop.clothes_shop.dto.ProductDto;
import com.clothes_shop.clothes_shop.exception.BadRequestException;
import com.clothes_shop.clothes_shop.exception.NotFoundException;
import com.clothes_shop.clothes_shop.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImp implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImp(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product getProductById(int id) {
        Product product = this.productRepository.findById(id)
                .orElseThrow(()-> new NotFoundException(EError.PRODUCT_NOT_FOUND));
        return product;
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> products = this.productRepository.findAll();
        return products;
    }

    @Override
    public String deleteProduct(int id) {
        Product product = this.productRepository.findById(id)
                .orElseThrow(()-> new NotFoundException(EError.PRODUCT_NOT_FOUND));
        this.productRepository.delete(product);
        return "Product has been deleted";
    }

    public Product updateProductFromDto(Product existedProduct, ProductDto dto) {
        if (dto.getName()!=null) {
            existedProduct.setName(dto.getName());
        }
        if (dto.getUrlPhoto()!=null) {
            existedProduct.setUrlPhoto(dto.getUrlPhoto());
        }
        if (dto.getDescription()!=null) {
            existedProduct.setDescription(dto.getDescription());
        }
        if (dto.getPrice() !=null){
            existedProduct.setPrice(dto.getPrice());
        }
        if (dto.getQuantity()!=null){
            existedProduct.setQuantity(dto.getQuantity());
        }
        if (dto.getColors()!=null){
            existedProduct.setColors(dto.getColors());
        }
        return existedProduct;
    }

    @Override
    public Product updateProduct(int id, ProductDto dto) {
        Product existedProduct = this.productRepository.findById(id)
                .orElseThrow(()-> new NotFoundException(EError.PRODUCT_NOT_FOUND));
        existedProduct = updateProductFromDto(existedProduct, dto);
        return this.productRepository.save(existedProduct);
    }

    @Override
    public Product addProduct(ProductDto dto) {
        Product existedProduct = this.productRepository.findByName(dto.getName());
        if (existedProduct == null){
            throw new BadRequestException(EError.PRODUCT_EXISTED);
        }
        Product newProduct = new Product(
                dto.getName(),
                dto.getDescription(),
                dto.getPrice(),
                dto.getQuantity(),
                dto.getUrlPhoto(),
                dto.getColors()
        );
        return this.productRepository.save(newProduct);
    }
}
