package main.java.cl.duoc.resenas.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.Builder;

import java.time.Instant;
import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConsturctor
@Builder
public class ResenasResponse {

    private UUID id;

    private UUID destinationsId;

    private UUID usersId;

    private Integer puntaje;

    private String comentario;

    private Instant CreacionComen;
    
    private Instant ActualizaComen;

}
