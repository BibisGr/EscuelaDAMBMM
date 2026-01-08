package progresa.escueladamb.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "inscripciones")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Inscripciones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fechaInscripcion", nullable = false)
    private String fechaInscripcion;
    @Column(name = "estado", nullable = false)
    private String estado;
    @Column(name = "nota", nullable = false)
    private Number nota;

    @ManyToOne
    @JoinColumn(name = "alumno_id", nullable = false)
    private Alumno alumno;

    @ManyToOne
    @JoinColumn(name = "curso_id", nullable = false)
    private Curso curso;
}
