package com.jt.prueba.artist.controller;

import com.jt.prueba.artist.application.dto.response.ArtistResponse;
import com.jt.prueba.artist.application.mapper.ArtistMapper;
import com.jt.prueba.artist.application.methods.ArtistMethods;
import com.jt.prueba.artist.application.dto.request.ArtistRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("artist")
public class PostArtistController {
    private final ArtistMethods methods;
    @Autowired
    PostArtistController(ArtistMethods methods){
        this.methods = methods;
    }
    @PostMapping
    public ResponseEntity<ArtistResponse> create(@RequestBody ArtistRequest body){
        if(body == null)
            return ResponseEntity.badRequest().build();
        ArtistResponse response = ArtistMapper.fromArtistToResponse(methods.createArtist(body.getIde_type(), body.getIde_number(), body.getNames(), body.getLast_names()));
        if(response == null)
            return ResponseEntity.badRequest().build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
