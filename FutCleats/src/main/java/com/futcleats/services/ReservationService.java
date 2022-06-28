package com.futcleats.services;

import com.futcleats.model.ReservationModel;
import com.futcleats.model.enums.ReservationStatus;
import com.futcleats.repository.ReservationRepository;
import com.futcleats.repository.UserRepository;
import com.futcleats.services.exception.RegraNegocioException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
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

    public ReservationModel findById(UUID id){
        return reservationRepository.findById(id).orElseThrow(() -> new RegraNegocioException("Reserva não encontrada"));
    }

    public ReservationModel save(ReservationModel reservationModel){
        return reservationRepository.save(reservationModel);
    }

    public  ReservationModel update(ReservationModel reservationModel, UUID id){
        reservationRepository.findById(id).orElseThrow(() -> new RegraNegocioException("Reserva não encontrada"));
        reservationModel.setId(id);
        reservationRepository.save(reservationModel);
        return reservationModel;
    }

    public UUID delete(UUID id){
       ReservationModel reservationModel = reservationRepository.findById(id).orElseThrow(() -> new RegraNegocioException("Reserva não encontrada"));
       reservationRepository.delete(reservationModel);
       return id;
    }

    public List<ReservationModel> findReservationByUser(UUID id){
        return reservationRepository.findAllReservationByUserModel(userRepository.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Usuário não encontrado para pesquisar a reserva.")));
    }
    public UUID cancelAppointment(UUID id){
        ReservationModel reservationModel = reservationRepository.findById(id).orElseThrow(() -> new RegraNegocioException("Reserva não encontrada"));
        reservationModel.setReservationStatus(ReservationStatus.CANCELED);
        reservationRepository.saveAndFlush(reservationModel);
        return id;
    }
}
