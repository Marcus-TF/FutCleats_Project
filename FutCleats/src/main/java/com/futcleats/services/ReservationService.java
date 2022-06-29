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

    private ReservationRepository reservationRepository;

    private UserRepository userRepository;

    public List<ReservationModel> findAll(){
        return reservationRepository.findAll();
    }

    public ReservationModel findById(UUID id) throws ReservationNotFoundException {
        return reservationRepository.findById(id).orElseThrow(() -> new ReservationNotFoundException(""));
    }

    public ReservationModel save(ReservationModel reservationModel){
        return reservationRepository.save(reservationModel);
    }

    public  ReservationModel update(ReservationModel reservationModel, UUID id) throws ReservationNotFoundException {
        reservationRepository.findById(id).orElseThrow(() -> new ReservationNotFoundException("Reserva não encontrada."));
        reservationModel.setId(id);
        reservationRepository.save(reservationModel);
        return reservationModel;
    }

    public UUID delete(UUID id) throws ReservationNotFoundException {
       ReservationModel reservationModel = reservationRepository.findById(id).orElseThrow(() -> new ReservationNotFoundException("Reserva não encontrada."));
       reservationRepository.delete(reservationModel);
       return id;
    }

    public List<ReservationModel> findReservationByUser(UUID id) throws ReservationNotFoundException {
        return reservationRepository.findAllReservationByUserModel(userRepository.findById(id)
                .orElseThrow(() -> new ReservationNotFoundException("Reserva não encontrada.")));
    }
    public UUID cancelAppointment(UUID id) throws ReservationNotFoundException {
        ReservationModel reservationModel = reservationRepository.findById(id).orElseThrow(() -> new ReservationNotFoundException("Reserva não encontrada."));
        reservationModel.setReservationStatus(ReservationStatus.CANCELED);
        reservationRepository.saveAndFlush(reservationModel);
        return id;
    }
}
