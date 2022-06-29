package com.futcleats.services;

import com.futcleats.model.FieldModel;
import com.futcleats.repository.FieldRepository;
import com.futcleats.exception.FieldNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class FieldService {

    private FieldRepository fieldRepository;

    public List<FieldModel> findAll() {
        return fieldRepository.findAll();
    }

    public FieldModel findById(UUID id) {
        return fieldRepository.findById(id).orElseThrow(() -> new FieldNotFoundException("Campo não encontrado."));
    }

    public FieldModel save(FieldModel fieldModel) {
        return fieldRepository.save(fieldModel);
    }

    public FieldModel update(FieldModel fieldModel, UUID id) {
        fieldRepository.findById(id).orElseThrow(() -> new FieldNotFoundException("Campo não encontrado."));
        fieldModel.setId(id);
        fieldRepository.save(fieldModel);
        return fieldModel;
    }

    public UUID delete(UUID id) {
        var fieldModel = fieldRepository.findById(id).orElseThrow(() -> new FieldNotFoundException("Campo não encontrado."));
        fieldRepository.delete(fieldModel);
        return id;
    }
}
