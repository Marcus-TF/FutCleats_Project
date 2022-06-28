package com.futcleats.http.controllers;

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
        return ResponseEntity.ok().body(FieldMapper.toResponse(fieldService.findById(Long.valueOf(fieldId))));
    }

    @PostMapping
    public ResponseEntity<FieldResponse> save(@Valid @RequestBody FieldRequest fieldRequest){
        return ResponseEntity.ok().body(FieldMapper.toResponse(fieldService.save(FieldMapper.toModel(fieldRequest))));
    }

    @PutMapping("/{fieldId}")
    public ResponseEntity<FieldResponse> update(@RequestBody FieldRequest fieldRequest, @Valid @PathVariable String fieldId){
        return ResponseEntity.ok().body(FieldMapper.toResponse(fieldService.update(FieldMapper.toModel(fieldRequest), Long.valueOf(fieldId))));
    }

    @DeleteMapping("/{fieldId}")
    public ResponseEntity<Long> delete(@PathVariable String fieldId){
        return ResponseEntity.ok().body(fieldService.delete(Long.valueOf(fieldId)));
    }
}
