package com.futcleats.services;

import com.futcleats.model.FieldModel;
import com.futcleats.repository.FieldRepository;
import com.futcleats.services.exception.FieldNotFoundException;
import com.futcleats.services.exception.UserNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class FieldService {

    private FieldRepository fieldRepository;

    public List<FieldModel> findAll(){
        return fieldRepository.findAll();
    }

    public FieldModel findById(UUID id) throws FieldNotFoundException {
        return fieldRepository.findById(id).orElseThrow(() -> new FieldNotFoundException());
    }

    public FieldModel save(FieldModel fieldModel){
        return fieldRepository.save(fieldModel);
    }

    public FieldModel update(FieldModel fieldModel, UUID id) throws FieldNotFoundException {
        fieldRepository.findById(id).orElseThrow(() -> new FieldNotFoundException());
        fieldModel.setId(id);
        fieldRepository.save(fieldModel);
        return fieldModel;
    }

    public UUID delete(UUID id) throws FieldNotFoundException {
        var fieldModel = fieldRepository.findById(id).orElseThrow(() -> new FieldNotFoundException());
        fieldRepository.delete(fieldModel);
        return id;
    }
}
