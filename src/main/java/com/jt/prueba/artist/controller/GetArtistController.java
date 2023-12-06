package com.jt.prueba.artist.controller;

import com.jt.prueba.artist.domain.Artist;
import com.jt.prueba.artist.domain.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("artist")
public class GetArtistController {
    private final ArtistService service;
    @Autowired
    GetArtistController(ArtistService service){
        this.service = service;
    }
    @GetMapping
    public ResponseEntity<List<Artist>> fetch(){
        return ResponseEntity.ok(service.getAllArtists());
    }
}
