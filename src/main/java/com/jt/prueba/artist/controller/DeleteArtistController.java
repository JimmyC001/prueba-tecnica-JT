package com.jt.prueba.artist.controller;

import com.jt.prueba.artist.application.dto.response.ArtistResponse;
import com.jt.prueba.artist.application.mapper.ArtistMapper;
import com.jt.prueba.artist.domain.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("artist")
public class DeleteArtistController {
    private final ArtistService service;
    @Autowired
    DeleteArtistController(ArtistService service){
        this.service = service;
    }
    @DeleteMapping("{type}/{id}")
    public ResponseEntity<ArtistResponse> delete(@PathVariable String type, @PathVariable String id){
        if(type == null || id == null)
            return ResponseEntity.badRequest().build();
        ArtistResponse response = ArtistMapper.fromArtistToResponse(service.deleteArtist(type, id));
        if(response == null)
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(response);
    }
}
