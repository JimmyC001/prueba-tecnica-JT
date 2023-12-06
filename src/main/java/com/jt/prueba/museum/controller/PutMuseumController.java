package com.jt.prueba.museum.controller;

import com.jt.prueba.museum.application.dto.MuseumRequest;
import com.jt.prueba.museum.application.dto.MuseumResponse;
import com.jt.prueba.museum.application.mapper.MuseumMapper;
import com.jt.prueba.museum.application.method.MuseumMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("museum")
public class PutMuseumController {
    private final MuseumMethod method;
    @Autowired
    PutMuseumController(MuseumMethod method){
        this.method = method;
    }
    @PutMapping("{id}")
    public ResponseEntity<MuseumResponse> update(@PathVariable Long id, @RequestBody MuseumRequest body){
        if(id == null || body == null)
            return ResponseEntity.badRequest().build();
        MuseumResponse response = MuseumMapper.fromMuseumToResponse(
                method.updateMuseum(body, id)
        );
        if(response == null)
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(response);
    }
}
