package com.futcleats.services;

import com.futcleats.model.FieldModel;
import com.futcleats.repository.FieldRepository;
import com.futcleats.services.exception.RegraNegocioException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class FieldService {

    private FieldRepository fieldRepository;

    public List<FieldModel> findAll(){
        return fieldRepository.findAll();
    }

    public FieldModel findById(UUID id){
        return fieldRepository.findById(id).orElseThrow(() -> new RegraNegocioException("Campo não encontrada"));
    }

    public FieldModel save(FieldModel fieldModel){
        return fieldRepository.save(fieldModel);
    }

    public FieldModel update(FieldModel fieldModel, UUID id){
        fieldRepository.findById(id).orElseThrow(() -> new RegraNegocioException("Campo não encontrada"));
        fieldModel.setId(id);
        fieldRepository.save(fieldModel);
        return fieldModel;
    }

    public UUID delete(UUID id){
        var fieldModel = fieldRepository.findById(id).orElseThrow(() -> new RegraNegocioException("Campo não encontrada"));
        fieldRepository.delete(fieldModel);
        return id;
    }
}
