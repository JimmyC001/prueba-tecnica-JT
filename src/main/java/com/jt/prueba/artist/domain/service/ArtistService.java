package com.jt.prueba.artist.domain.service;

import com.jt.prueba.artist.domain.Artist;
import com.jt.prueba.artwork.domain.Artwork;

import java.util.List;

public interface ArtistService {
    List<Artist> getAllArtists();
    Artist createArtist(Artist artist);
    Artist getArtistFromTypeAndId(String type, String id);
    List<Artwork> getArtworkFromArtist(Long id, String country);
    Artist updateArtist(Artist artist, String type, String id);
    Artist deleteArtist(String type, String id);
}
