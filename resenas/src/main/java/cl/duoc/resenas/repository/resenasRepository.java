package main.java.cl.duoc.resenas.repository;

import main.java.cl.duoc.resenas.model.resenasModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Repository
public interface resenasRepository extends JpaRespository<resenasModel, UUID> {
    Optional<resenasModel> findByDestinationIdAndUsersId(UUID destinationsId, UUID usersId);

    List<resenasModel> findAllByUsersId(UUID usersId);

    List<resenasModel> findAllByDestinationsId(UUID destinationsId);

    @org.springframework.data.jpa.repository.Query(
        "SELECT AVG(r.puntaje) FROM resenas r WHERE r.destinationsId = :destinationsId")
    Double findAveragePuntajeByDestinationsId(UUID destinationsId);
}