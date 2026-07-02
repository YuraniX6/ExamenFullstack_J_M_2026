package main.java.cl.duoc.resenas.service;

import main.java.cl.duoc.resenas.model.resenasModel;
import main.java.cl.duoc.resenas.dto.resenasRequest;
import main.java.cl.duoc.resenas.dto.resenasResponse;
import main.java.cl.duoc.resenas.model;
import main.java.cl.duoc.resenas.repository.resenasRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


public class ResenasService {

    private final ResenasService resenasService;

private ResenasResponse mapToResponse(resenasModel resenasModel){
    return ResenasResponse.builder()
            .id(resenasModel.getId())
            .usersId(resenasModel.getUsersId())
            .destinationsId(resenasModel.getDestinationsId())
            .puntaje(resenasModel.getPuntaje())
            .comentario(resenasModel.getComentario())
            .creacionComen(resenasModel.getCreacionComen())
            .actualizaComen(resenasModel.getActualizaComen())
            .build();
    }
public ResenasResponse crearOActualizar (UUID usersId,ResenasRequest request){
    log.info("Creando/actualizando el puntaje del viaje: {} por el usuario: {}", request.getDestinationsId(), usersId);

    ResenasModel resenasModel = ResenasRepository.findByUsersIdAndDestinationsId(request.getDestinationsId(), usersId)
            .map(existing -> {
                log.ingo("Resena encontrada, actualizandola");
                existing.setPuntaje(request.getPuntaje());
                existing.setComentario(request.getComentario());
                return existing;
            })
            .orElseGet(() -> {
                log.info("No existe una resena, creando una nueva");
                return resenasModel.builder()
                .destinationsId(request.getDestinationsId())
                .usersId(usersId)
                .puntaje(request.getPuntaje())
                .comentario(request.getComentario())
                .build();
            });

    ResenasModel saved = ResenasRepository.save(ResenasModel);

    log.info("Resena guardada con id : {} para el viaje: {} por el usuario: {}", saved.getId(), saved.getDestinationsId(), usersId);

    return mapToResponse(saved);
}

@Transactional(readOnly = true)
public List<ResenasResponse> getMyResenasModel(UUID userId){
    log.info("Agarrando todas las resenas del usuario: {}", userId);

    List<ResenasModel> resenasModel = resenasRepository.findAllByUserId(userId);

    log.info("Encontrado {} resenas del usuario: {}", userId);

    return resenasModel.stream()
            .map(this::mapToResponse)
            .toList();
        }   

}
