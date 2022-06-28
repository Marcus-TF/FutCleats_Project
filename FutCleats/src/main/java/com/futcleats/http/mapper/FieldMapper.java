package com.futcleats.http.mapper;

import com.futcleats.http.dto.request.FieldRequest;
import com.futcleats.http.dto.response.FieldResponse;
import com.futcleats.model.FieldModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Component
public class FieldMapper {

    public static FieldModel toModel(FieldRequest fieldRequest){
        return FieldModel.builder()
                .name(fieldRequest.getName())
                .build();
    }

    public static FieldResponse toResponse(FieldModel fieldModel){
        return FieldResponse.builder()
                .id(fieldModel.getId())
                .name(fieldModel.getName())
                .reservationResponseList(ReservationMapper.toResponseList(fieldModel.getReservationModelList()))
                .build();
    }

    public static List<FieldResponse> toResponseList(List<FieldModel> fieldModelList) {
        if (isNull(fieldModelList) || fieldModelList.isEmpty()) {
            return new ArrayList<>();
        } else {
            return fieldModelList.stream().map(FieldMapper::toResponse).collect(Collectors.toList());
        }
    }

}
