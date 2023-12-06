package com.jt.prueba.museum.domain.repository;

import com.jt.prueba.museum.domain.Museum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MuseumRespository extends JpaRepository<Museum, Long> {
    @Query("SELECT m FROM Museum m WHERE m.city = :city AND UPPER(m.name) LIKE CONCAT(UPPER(:prefix), '%')")
    List<Museum> findByCityAndFirstLetter(String city,@Param("prefix") String c);
}
