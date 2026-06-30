package main.java.cl.duoc.resenas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.Builder;
import java.util.UUID;
import java.time.Instant;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;



@Entity
@Table(name = "resenas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class resenasModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "destination_id", nullable = false)
    private UUID destinationsId;

    @Column(name = "users_id", nullable = false)
    private UUID userId;

    @Column(name = "puntaje", nullable = false)
    private Integer puntaje;

    @Column(name = "comentario", length = 1000)
    private String comentario;    

    @CreationTimestamp
    @Column(name = "creado_a_las", nullable = false, updatable = false)
    private Instant creacionComen;

    @UpdateTimestamp
    @Column(name = "actualizado_a_las", nullable = false)
    private Instant actualizaComen;

}
