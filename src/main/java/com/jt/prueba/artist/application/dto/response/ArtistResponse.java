package com.jt.prueba.artist.application.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ArtistResponse {
    private String ide_type;
    private String ide_number;
    private String names;
    private String last_names;
}
