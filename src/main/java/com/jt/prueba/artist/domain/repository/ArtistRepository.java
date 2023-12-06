package com.jt.prueba.artist.domain.repository;

import com.jt.prueba.artist.domain.Artist;
import com.jt.prueba.artwork.domain.Artwork;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long> {
    Optional<Artist> findArtistByIdeTypeAndIdeNumber(String ide_type, String ide_number);
    @Query("SELECT a FROM Artwork a WHERE a.artist.id = :id AND a.country = :country")
    List<Artwork> getArtworkFromArtist(Long id, String country);
}
