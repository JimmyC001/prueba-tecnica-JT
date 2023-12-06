package com.jt.prueba.museum.domain.service;

import com.jt.prueba.museum.domain.Museum;

import java.util.List;

public interface MuseumService {
    List<Museum> getFromCityAndStartingChar(String city, String c);
}
