package com.jt.prueba.museum.controller;

import com.jt.prueba.museum.application.dto.MuseumRequest;
import com.jt.prueba.museum.application.dto.MuseumResponse;
import com.jt.prueba.museum.application.mapper.MuseumMapper;
import com.jt.prueba.museum.application.method.MuseumMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("museum")
public class PostMuseumController {
    private final MuseumMethod method;
    @Autowired
    PostMuseumController(MuseumMethod method){
        this.method = method;
    }
    @PostMapping
    public ResponseEntity<MuseumResponse> create(@RequestBody MuseumRequest request){
        if(request == null)
            return ResponseEntity.badRequest().build();
        MuseumResponse response = MuseumMapper.fromMuseumToResponse(
                method.createMuseum(request)
        );
        if(response == null)
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(response);
    }
}
