package com.jt.prueba.artist.controller;

import com.jt.prueba.artist.application.methods.ArtistMethods;
import com.jt.prueba.artwork.domain.Artwork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("artist")
public class GetArtworkFromArtist {
    private final ArtistMethods methods;
    @Autowired
    GetArtworkFromArtist(ArtistMethods methods){
        this.methods = methods;
    }

    @GetMapping("{type}/{id}/artwork")
    public ResponseEntity<List<Artwork>> fetch(@PathVariable("type") String type, @PathVariable("id") String id, @RequestParam(name = "country", defaultValue = "colombia") String country){
        if(type == null || id == null || country == null)
            return ResponseEntity.badRequest().build();
        List<Artwork> artworkList = methods.getArtworkFromArtistAndCountry(type, id, country);
        if(artworkList == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(artworkList);
    }
}
