package com.jt.prueba.artist.application.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostArtistRequest {
    private String ide_type;
    private String ide_number;
    private String names;
    private String last_names;
}
