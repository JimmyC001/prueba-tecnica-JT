package com.jt.prueba.artist.domain.service;

import com.jt.prueba.artist.domain.Artist;
import com.jt.prueba.artwork.domain.Artwork;

import java.util.List;

public interface ArtistService {
    Artist createArtist(Artist artist);
    Artist getArtistFromTypeAndId(String type, String id);
    public List<Artwork> getArtworkFromArtist(Long id, String country);
}
