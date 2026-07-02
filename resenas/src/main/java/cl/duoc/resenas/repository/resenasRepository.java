package main.java.cl.duoc.resenas.repository;

import main.java.cl.duoc.resenas.model.ResenasModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Repository
public interface ResenasRepository extends JpaRespository<resenasModel, UUID> {
    Optional<ResenasModel> findByDestinationIdAndUsersId(UUID destinationsId, UUID usersId);

    List<ResenasModel> findAllByUsersId(UUID usersId);

    List<ResenasModel> findAllByDestinationsId(UUID destinationsId);

    @org.springframework.data.jpa.repository.Query(
        "SELECT AVG(r.puntaje) FROM resenas r WHERE r.destinationsId = :destinationsId")
    Double findAveragePuntajeByDestinationsId(UUID destinationsId);
}