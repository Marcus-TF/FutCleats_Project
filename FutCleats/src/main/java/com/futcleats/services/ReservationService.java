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

@Service
@AllArgsConstructor
public class ReservationService {

    private ReservationRepository reservationRepository;

    private UserRepository userRepository;

    public List<ReservationModel> findAll(){
        return reservationRepository.findAll();
    }

    public ReservationModel findById(Long id){
        return reservationRepository.findById(id).orElseThrow(() -> new RegraNegocioException("Reserva não encontrada"));
    }

    public ReservationModel save(ReservationModel reservationModel){
        return reservationRepository.save(reservationModel);
    }

    public  ReservationModel update(ReservationModel reservationModel, Long id){
        reservationRepository.findById(id).orElseThrow(() -> new RegraNegocioException("Reserva não encontrada"));
        reservationModel.setId(id);
        reservationRepository.save(reservationModel);
        return reservationModel;
    }

    public Long delete(Long id){
       ReservationModel reservationModel = reservationRepository.findById(id).orElseThrow(() -> new RegraNegocioException("Reserva não encontrada"));
       reservationRepository.delete(reservationModel);
       return id;
    }

    public List<ReservationModel> findReservationByUser(Long id){
        return reservationRepository.findAllReservationByUserModel(userRepository.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Usuário não encontrado para pesquisar a reserva.")));
    }
    public Long cancelAppointment(Long id){
        ReservationModel reservationModel = reservationRepository.findById(id).orElseThrow(() -> new RegraNegocioException("Reserva não encontrada"));
        reservationModel.setReservationStatus(ReservationStatus.CANCELED);
        reservationRepository.saveAndFlush(reservationModel);
        return id;
    }
}
