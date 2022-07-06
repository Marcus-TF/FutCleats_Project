package com.futcleats.http.mapper;

import com.futcleats.http.dto.request.CategoryRequest;
import com.futcleats.http.dto.response.CategoryResponse;
import com.futcleats.model.CategoryModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Component
public class CategoryMapper {

    public static CategoryModel toModel(CategoryRequest categoryRequest){
        return CategoryModel.builder()
                .category(categoryRequest.getCategory())
                .build();
    }

    public static CategoryResponse toResponse(CategoryModel categoryModel){
        return CategoryResponse.builder()
                .uuid(categoryModel.getUuid())
                .category(categoryModel.getCategory())
                .build();
    }

    public static List<CategoryResponse> toResponseList(List<CategoryModel> categoryModelList){
        if(isNull(categoryModelList) || categoryModelList.isEmpty()){
            return new ArrayList<>();
        } else {
            return categoryModelList.stream().map(CategoryMapper::toResponse).collect(Collectors.toList());
        }
    }
}
