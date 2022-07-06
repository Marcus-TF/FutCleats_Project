package com.futcleats.http.controller;

import com.futcleats.http.dto.request.FieldRequest;
import com.futcleats.http.dto.response.FieldResponse;
import com.futcleats.http.mapper.FieldMapper;
import com.futcleats.services.FieldService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/fields")
@AllArgsConstructor
@Validated
public class FieldController {

    private final FieldService fieldService;

    @GetMapping("/all")
    public ResponseEntity<List<FieldResponse>> findAll(){
        return ResponseEntity.ok().body(FieldMapper.toResponseList(fieldService.findAll()));
    }

    @GetMapping("/{fieldId}")
    public ResponseEntity<FieldResponse> findById(@PathVariable String fieldId){
            return ResponseEntity.ok().body(FieldMapper.toResponse(fieldService.findById(UUID.fromString(fieldId))));
    }

    @PostMapping
    public ResponseEntity<FieldResponse> save(@Valid @RequestBody FieldRequest fieldRequest){
        return ResponseEntity.ok().body(FieldMapper.toResponse(fieldService.save(FieldMapper.toModel(fieldRequest))));
    }

    @PutMapping("/{fieldId}")
    public ResponseEntity<FieldResponse> update(@RequestBody @Valid FieldRequest fieldRequest, @PathVariable String fieldId){
            return ResponseEntity.ok().body(FieldMapper.toResponse(fieldService.update(FieldMapper.toModel(fieldRequest), UUID.fromString(fieldId))));
    }

    @DeleteMapping("/{fieldId}")
    public ResponseEntity<UUID> delete(@PathVariable String fieldId){
            return ResponseEntity.ok().body(fieldService.delete(UUID.fromString(fieldId)));
    }

    @GetMapping("/findAllFieldsByCategory/{categoryId}")
    public ResponseEntity<List<FieldResponse>> findAllFieldsByCategory(@PathVariable String categoryId){
        return ResponseEntity.ok().body(FieldMapper.toResponseList(fieldService.findAllFieldsByCategory(UUID.fromString(categoryId))));
    }
}
