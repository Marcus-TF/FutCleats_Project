package com.futcleats.repository;

import com.futcleats.model.FieldModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FieldRepository extends JpaRepository<FieldModel, UUID> {
}
