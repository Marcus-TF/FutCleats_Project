package com.futcleats.http.controllers;

import com.futcleats.http.dto.request.ProductRequest;
import com.futcleats.http.dto.response.ProductResponse;
import com.futcleats.http.mapper.ProductMapper;
import com.futcleats.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;


@Validated
@RestController
@AllArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/all")
    public ResponseEntity<List<ProductResponse>> findAll() {
        return ResponseEntity.ok().body(ProductMapper.toResponseList(productService.findAll()));
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductResponse> findById(@PathVariable String productId) {
        return ResponseEntity.ok().body(ProductMapper.toResponse(productService.findById(UUID.fromString(productId))));
    }

    @PostMapping("/create")
    public ResponseEntity<ProductResponse> save(@RequestBody @Valid ProductRequest productRequest) {
        return ResponseEntity.ok().body(ProductMapper.toResponse(productService.save(ProductMapper.toModel(productRequest))));
    }

    @PutMapping("/{productId}")
    public ResponseEntity<ProductResponse> update(@RequestBody @Valid ProductRequest productRequest, @PathVariable String productId) {
        return ResponseEntity.ok().body(ProductMapper.toResponse(productService.update(ProductMapper.toModel(productRequest), UUID.fromString(productId))));
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<UUID> delete(@PathVariable String productId){
        return ResponseEntity.ok().body(productService.delete(UUID.fromString(productId)));
    }
}
