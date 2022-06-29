package com.futcleats.services;

import com.futcleats.model.ReservationModel;
import com.futcleats.model.enums.ReservationStatus;
import com.futcleats.repository.ReservationRepository;
import com.futcleats.repository.UserRepository;
import com.futcleats.exception.ReservationNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;

    private final UserRepository userRepository;

    public List<ReservationModel> findAll() {
        return reservationRepository.findAll();
    }

    public ReservationModel findById(UUID id) {
        return reservationRepository.findById(id).orElseThrow(() -> new ReservationNotFoundException(""));
    }

    public ReservationModel save(ReservationModel reservationModel) {
        return reservationRepository.save(reservationModel);
    }

    public ReservationModel update(ReservationModel reservationModel, UUID id) {
        reservationRepository.findById(id).orElseThrow(() -> new ReservationNotFoundException("Reserva não encontrada."));
        reservationModel.setId(id);
        reservationRepository.save(reservationModel);
        return reservationModel;
    }

    public UUID delete(UUID id) {
        ReservationModel reservationModel = reservationRepository.findById(id).orElseThrow(() -> new ReservationNotFoundException("Reserva não encontrada."));
        reservationRepository.delete(reservationModel);
        return id;
    }

    public List<ReservationModel> findReservationByUser(UUID id) {
        return reservationRepository.findAllReservationByUserModel(userRepository.findById(id)
                .orElseThrow(() -> new ReservationNotFoundException("Reserva não encontrada.")));
    }

    public UUID cancelAppointment(UUID id) {
        ReservationModel reservationModel = reservationRepository.findById(id).orElseThrow(() -> new ReservationNotFoundException("Reserva não encontrada."));
        reservationModel.setReservationStatus(ReservationStatus.CANCELED);
        reservationRepository.saveAndFlush(reservationModel);
        return id;
    }
}
