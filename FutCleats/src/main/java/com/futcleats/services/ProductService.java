package com.futcleats.services;

import com.futcleats.exception.ProductNotFoundException;
import com.futcleats.model.ProductModel;
import com.futcleats.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<ProductModel> findAll() {
        return productRepository.findAll();
    }

    public ProductModel findById(UUID uuid) {
        return productRepository.findById(uuid)
                .orElseThrow(() -> new ProductNotFoundException("Produto não encontrado."));
    }

    public ProductModel save(ProductModel productModel) {
        return productRepository.save(productModel);
    }

    public ProductModel update(ProductModel productModel, UUID uuid) {
        productRepository.findById(uuid)
                .orElseThrow(() -> new ProductNotFoundException("Produto não encontrado."));
        productModel.setUuid(uuid);
        productRepository.save(productModel);
        return productModel;
    }

    public UUID delete(UUID uuid) {
        var productModel = productRepository.findById(uuid)
                .orElseThrow(() -> new ProductNotFoundException("Produto não encontrado."));
        productRepository.delete(productModel);
        return uuid;
    }
}
