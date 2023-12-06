package com.jt.prueba.artist.controller;

import com.jt.prueba.artist.application.dto.request.ArtistRequest;
import com.jt.prueba.artist.application.dto.response.ArtistResponse;
import com.jt.prueba.artist.application.mapper.ArtistMapper;
import com.jt.prueba.artist.application.methods.ArtistMethods;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("artist")
public class PutArtisController {
    private final ArtistMethods methods;
    @Autowired
    PutArtisController(ArtistMethods methods){
        this.methods = methods;
    }
    @PutMapping("{type}/{id}")
    public ResponseEntity<ArtistResponse> update(@PathVariable String type, @PathVariable String id, @RequestBody ArtistRequest body){
        if(body == null || type == null || id == null)
            return ResponseEntity.badRequest().build();
        ArtistResponse response = ArtistMapper.fromArtistToResponse(
                methods.updateArtist(ArtistMapper.fromRequestToArtist(body), type, id)
        );
        if(response == null)
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(response);
    }
}
