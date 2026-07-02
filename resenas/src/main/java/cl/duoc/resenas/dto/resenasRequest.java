package main.java.cl.duoc.resenas.dto;

import jakarta.validation.constraint.Max;
import jakarta.validation.constraint.Min;
import jakarta.validation.constraint.NotNull;
import jakarta.validation.constraint.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Builder;
import java.util.UUID;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResenasRequest {

    @NotNull(message = "usersId no puede ser nulo")
    private UUID usersId;

    @NotNull(message = "destinationsId no puede ser nulo")
    private UUID destinationsId;

    @NotNull(message = "puntaje no puede estar vacio")
    @Min(value = 1, message = "puntaje debe ser de almenos 1")
    @Max(value = 10, message = "puntaje no debe exceder 10")
    private Integer puntaje;

    @Size(max = 1500, message = "comentario no debe exceder las 1500 letras")
    private String comentario;

}
