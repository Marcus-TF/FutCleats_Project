package com.futcleats.repository;

import com.futcleats.model.ReservationModel;
import com.futcleats.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<ReservationModel, Long> {

    List<ReservationModel> findAllReservationByUserModel(UserModel userModel);

}
