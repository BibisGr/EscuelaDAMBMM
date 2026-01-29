package progresa.escueladamb.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
    @Column(name = "creditos", nullable = false)
    private Number creditos;

//    @OneToMany(mappedBy = "curso")
//    @JsonIgnore
//    private List<Inscripciones> Inscripciones = new ArrayList<>();

    @ManyToMany(mappedBy = "cursos")
//    @JsonIgnore
    @JsonBackReference
    private Set<Alumno> Alumnos = new HashSet<>();
}


