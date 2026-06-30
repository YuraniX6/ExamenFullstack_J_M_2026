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


public class resenasService {

    private final resenasService resenasService;

private resenasResponse mapToResponse(resenasModel resenasModel){
    return resenasResponse.builder()
            .id(resenasModel.getId())
            .usersId(resenasModel.getUsersId())
            .destinationsId(resenasModel.getDestinationsId())
            .puntaje(resenasModel.getPuntaje())
            .comentario(resenasModel.getComentario())
            .creacionComen(resenasModel.getCreacionComen())
            .actualizaComen(resenasModel.getActualizaComen())
            .build();
    }
public resenasResponse crearOActualizar (UUID usersId,)

}
