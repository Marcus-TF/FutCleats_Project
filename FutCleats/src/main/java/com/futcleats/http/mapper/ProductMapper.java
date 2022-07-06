package com.futcleats.http.mapper;

import com.futcleats.http.dto.request.ProductRequest;
import com.futcleats.http.dto.response.ProductResponse;
import com.futcleats.model.CategoryModel;
import com.futcleats.model.ProductModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Component
public class ProductMapper {

    public static ProductModel toModel(ProductRequest productRequest) {
        return ProductModel.builder()
                .name(productRequest.getName())
                .quantidade(productRequest.getQuantidade())
                .value(productRequest.getValue())
                .categoryModel(CategoryModel.builder().uuid(productRequest.getCodCategory()).build())
                .build();
    }

    public static ProductResponse toResponse(ProductModel productModel) {
        return ProductResponse.builder()
                .uuid(productModel.getUuid())
                .name(productModel.getName())
                .quantidade(productModel.getQuantidade())
                .value(productModel.getValue())
                .build();
    }

    public static List<ProductResponse> toResponseList(List<ProductModel> productModelList) {
        if (isNull(productModelList) || productModelList.isEmpty()) {
            return new ArrayList<>();
        } else {
            return productModelList.stream().map(ProductMapper::toResponse).collect(Collectors.toList());
        }
    }
}
