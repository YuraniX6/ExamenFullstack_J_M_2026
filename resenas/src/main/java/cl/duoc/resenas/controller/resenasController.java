package main.java.cl.duoc.resenas.controller;
import main.java.cl.duoc.resenas.dto.resenasRequest;
import main.java.cl.duoc.resenas.dto.resenasResponse;
import main.java.cl.duoc.resenas.service.resenasService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityRequirements;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/resenas")
@RequiredArgsConstructor
public class ResenasController {

    private final ResenasService resenasService;

    @PostMapping
    @Operation(summary = "Crear o actualizar la resena",
        description = "Crear una nueva resena o actualizar una existente")
     @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Resena creada o actualizada successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResenasResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalido request body o validacion fallida"),
            @ApiResponse(responseCode = "401", description = "Unautorizadd - invalido o perdido JWT token")
    })
    public ResponseEntity<ResenaResponse> crearOActualizarResena(
            @Valid @RequestBody ResenaRequest request, // @Valid activa las validaciones definidas en RatingRequest (@NotNull, @Min, @Max, @Size).
            Authentication authentication) { // Spring inyecta automáticamente la autenticación que dejó JwtAuthenticationFilter.
        log.info("POST /resenas - Creando o actualizando resena");

        return ResponseEntity.ok(response);
    }

}
