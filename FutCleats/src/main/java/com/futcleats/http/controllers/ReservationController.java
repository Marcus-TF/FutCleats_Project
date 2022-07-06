package com.futcleats.http.controllers;

import com.futcleats.http.dto.request.ReservationRequest;
import com.futcleats.http.dto.response.ReservationResponse;
import com.futcleats.http.mapper.ReservationMapper;
import com.futcleats.services.ReservationService;
import com.futcleats.exception.ReservationNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Validated
@RestController
@RequestMapping("/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    @GetMapping("/all")
    public ResponseEntity<List<ReservationResponse>> findAll(){
        return ResponseEntity.ok().body(ReservationMapper.toResponseList(reservationService.findAll()));
    }

    @GetMapping("/{reservationId}")
    public ResponseEntity<ReservationResponse> findById(@PathVariable String reservationId){
            return ResponseEntity.ok().body(ReservationMapper.toResponse(reservationService.findById(UUID.fromString(reservationId))));
    }

    @PostMapping
    public ResponseEntity<ReservationResponse> save(@Valid @RequestBody ReservationRequest reservationRequest){
        return ResponseEntity.ok().body(ReservationMapper.toResponse(reservationService.save(ReservationMapper.toModel(reservationRequest))));
    }

    @PutMapping("/{reservationId}")
    public ResponseEntity<ReservationResponse> update(@RequestBody @Valid ReservationRequest reservationRequest, @PathVariable String reservationId){
            return ResponseEntity.ok().body(ReservationMapper.toResponse(reservationService.update(ReservationMapper.toModel(reservationRequest), UUID.fromString(reservationId))));
    }

    @DeleteMapping("/{reservationId}")
    public ResponseEntity<UUID> delete(@PathVariable String reservationId){
            return ResponseEntity.ok().body(reservationService.delete(UUID.fromString(reservationId)));
    }


    @GetMapping("/findReservationByUser/{userId}")
    public ResponseEntity<List<ReservationResponse>> findReservationByUser(@PathVariable String userId){
            return ResponseEntity.ok().body(ReservationMapper.toResponseList(reservationService.findReservationByUser(UUID.fromString(userId))));
    }

}
