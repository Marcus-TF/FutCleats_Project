package com.futcleats.services;

import com.futcleats.model.FieldModel;
import com.futcleats.repository.FieldRepository;
import com.futcleats.services.exception.RegraNegocioException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.List;

@Service
@AllArgsConstructor
public class FieldService {

    private FieldRepository fieldRepository;

    public List<FieldModel> findAll(){
        return fieldRepository.findAll();
    }

    public FieldModel findById(Long id){
        return fieldRepository.findById(id).orElseThrow(() -> new RegraNegocioException("Campo não encontrada"));
    }

    public FieldModel save(FieldModel fieldModel){
        return fieldRepository.save(fieldModel);
    }

    public FieldModel update(FieldModel fieldModel, Long id){
        fieldRepository.findById(id).orElseThrow(() -> new RegraNegocioException("Campo não encontrada"));
        fieldModel.setId(id);
        fieldRepository.save(fieldModel);
        return fieldModel;
    }

    public Long delete(Long id){
        var fieldModel = fieldRepository.findById(id).orElseThrow(() -> new RegraNegocioException("Campo não encontrada"));
        fieldRepository.delete(fieldModel);
        return id;
    }
}
