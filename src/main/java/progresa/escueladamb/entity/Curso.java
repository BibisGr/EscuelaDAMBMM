package progresa.escueladamb.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "curso")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;
//    @Column(name = "descricion", nullable = false)
//    private String descripcion;
//    @Column(name = "fechaInicio", nullable = false)
//    private String fechaInicio;
//    @Column(name = "fechaFin", nullable = false)
//    private String fechaFin;
    @Column(name = "creditos", nullable = false)
    private Number creditos;

//    @OneToMany(mappedBy = "curso")
//    @JsonIgnore
//    private List<Inscripciones> Inscripciones = new ArrayList<>();

    @ManyToMany(mappedBy = "cursos")
    @JsonBackReference
    private Set<Alumno> alumnos = new HashSet<>();
}


