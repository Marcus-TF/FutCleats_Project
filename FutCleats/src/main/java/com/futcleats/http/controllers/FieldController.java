package com.futcleats.http.controllers;

import com.futcleats.http.dto.request.FieldRequest;
import com.futcleats.http.dto.response.FieldResponse;
import com.futcleats.http.mapper.FieldMapper;
import com.futcleats.services.FieldService;
import com.futcleats.services.exception.FieldNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/fields")
@AllArgsConstructor
@Validated
public class FieldController {

    private FieldService fieldService;

    @GetMapping("/all")
    public ResponseEntity<List<FieldResponse>> findAll(){
        return ResponseEntity.ok().body(FieldMapper.toResponseList(fieldService.findAll()));
    }

    @GetMapping("/{fieldId}")
    public ResponseEntity<FieldResponse> findById(@PathVariable String fieldId){
        try {
            return ResponseEntity.ok().body(FieldMapper.toResponse(fieldService.findById(UUID.fromString(fieldId))));
        } catch (FieldNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Campo não encontrado.", e);
        }
    }

    @PostMapping
    public ResponseEntity<FieldResponse> save(@Valid @RequestBody FieldRequest fieldRequest){
        return ResponseEntity.ok().body(FieldMapper.toResponse(fieldService.save(FieldMapper.toModel(fieldRequest))));
    }

    @PutMapping("/{fieldId}")
    public ResponseEntity<FieldResponse> update(@RequestBody FieldRequest fieldRequest, @Valid @PathVariable String fieldId){
        try {
            return ResponseEntity.ok().body(FieldMapper.toResponse(fieldService.update(FieldMapper.toModel(fieldRequest), UUID.fromString(fieldId))));
        } catch (FieldNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Campo não encontrado.", e);
        }
    }

    @DeleteMapping("/{fieldId}")
    public ResponseEntity<UUID> delete(@PathVariable String fieldId){
        try {
            return ResponseEntity.ok().body(fieldService.delete(UUID.fromString(fieldId)));
        } catch (FieldNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Campo não encontrado.", e);
        }
    }
}
