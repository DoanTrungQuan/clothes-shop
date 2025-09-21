package com.clothes_shop.clothes_shop.service;

import com.clothes_shop.clothes_shop.common.EError;
import com.clothes_shop.clothes_shop.domain.HashtagCategory;
import com.clothes_shop.clothes_shop.domain.Product;
import com.clothes_shop.clothes_shop.dto.ProductDto;
import com.clothes_shop.clothes_shop.exception.BadRequestException;
import com.clothes_shop.clothes_shop.exception.NotFoundException;
import com.clothes_shop.clothes_shop.repository.HashtagCategoryRepository;
import com.clothes_shop.clothes_shop.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImp implements ProductService {
    private final ProductRepository productRepository;
    private final HashtagCategoryRepository hashtagCategoryRepository;

    public ProductServiceImp(ProductRepository productRepository,  HashtagCategoryRepository hashtagCategoryRepository) {
        this.productRepository = productRepository;
        this.hashtagCategoryRepository = hashtagCategoryRepository;
    }

    @Override
    public Product getProductById(Long id) {
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
    public String deleteProduct(Long id) {
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
        if (dto.getPrice() !=0){
            existedProduct.setPrice(dto.getPrice());
        }
        if (dto.getProductCode()!=null) {
            existedProduct.setProductCode(dto.getProductCode());
        }
        return existedProduct;
    }

    @Override
    public Product updateProduct(Long id, ProductDto dto) {
        Product existedProduct = this.productRepository.findById(id)
                .orElseThrow(()-> new NotFoundException(EError.PRODUCT_NOT_FOUND));
        existedProduct = updateProductFromDto(existedProduct, dto);
        return this.productRepository.save(existedProduct);
    }

    @Override
    public Product addProduct(ProductDto dto) {
        Product existedProduct = this.productRepository.findByName(dto.getName());
        if (existedProduct != null){
            throw new BadRequestException(EError.PRODUCT_EXISTED);
        }
//        HashtagCategory hashtagCategory = this.hashtagCategoryRepository.findByName(dto.getHashtagCategory());
//        if (hashtagCategory == null){
//            throw new NotFoundException(EError.HASHTAG_CATEGORY_NOT_FOUND);
//        }
        Product newProduct = new Product();
        newProduct.setName(dto.getName());
        newProduct.setUrlPhoto(dto.getUrlPhoto());
        newProduct.setDescription(dto.getDescription());
        newProduct.setPrice(dto.getPrice());
        newProduct.setProductCode(dto.getProductCode());
//        newProduct.setHashtagCategory(hashtagCategory);
        return this.productRepository.save(newProduct);
    }
}
