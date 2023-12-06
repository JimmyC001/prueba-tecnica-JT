package com.jt.prueba.museum.controller;

import com.jt.prueba.museum.domain.Museum;
import com.jt.prueba.museum.domain.service.MuseumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("museum")
public class GetMuseumController {
    private final MuseumService service;
    @Autowired
    GetMuseumController(MuseumService service){
        this.service = service;
    }
    @GetMapping
    public ResponseEntity<List<Museum>> fetch(){
        return ResponseEntity.ok(service.getAllMuseums());
    }
}
