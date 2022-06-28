package com.futcleats.http.mapper;

import com.futcleats.http.dto.request.ReservationRequest;
import com.futcleats.http.dto.response.ReservationResponse;
import com.futcleats.model.FieldModel;
import com.futcleats.model.ReservationModel;
import com.futcleats.model.UserModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Component
public class ReservationMapper {

    public static ReservationModel toModel(ReservationRequest reservationRequest){
        return ReservationModel.builder()
                .hour(reservationRequest.getHour())
                .bookingDate(reservationRequest.getBookingDate())
                .reservationStatus(reservationRequest.getReservationStatus())
                .userModel(UserModel.builder().id(reservationRequest.getIdUser()).build())
                .fieldModel(FieldModel.builder().id(reservationRequest.getIdField()).build())
                .build();
    }

    public static ReservationResponse toResponse(ReservationModel reservationModel){
        return ReservationResponse.builder()
                .id(reservationModel.getId())
                .hour(reservationModel.getHour())
                .bookingDate(reservationModel.getBookingDate())
                .reservationStatus(reservationModel.getReservationStatus())
                .idUser(reservationModel.getUserModel().getId())
                .nameUser(reservationModel.getUserModel().getName())
                .idField(reservationModel.getFieldModel().getId())
                .nameField(reservationModel.getFieldModel().getName())
                .build();
    }

    public static List<ReservationResponse> toResponseList(List<ReservationModel> reservationModelList){
        if (isNull(reservationModelList) || reservationModelList.isEmpty()){
            return new ArrayList<>();
        } else {
            return reservationModelList.stream().map(ReservationMapper::toResponse).collect(Collectors.toList());
        }
    }
}
