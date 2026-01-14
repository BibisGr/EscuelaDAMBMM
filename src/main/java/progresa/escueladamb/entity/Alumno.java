package progresa.escueladamb.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "alumno")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;
//    @Column(name = "Apellidos", nullable = false)
//    private String apellidos;
//    @Column(name = "FechaNaciemiento", nullable = false)
//    private String fechaNaciemiento;
//    @Column(name = "dni", nullable = false)
//    private String dni;
//    @Column(name = "email", nullable = false)
//    private String email;

//    @OneToMany(mappedBy = "alumno")
//    @JsonIgnore
//    private List<Inscripciones> inscripciones = new ArrayList<>();


    @ManyToMany
    @JoinTable(
            name = "alumno_curso",
            joinColumns = @JoinColumn(name = "alumno_id"),
            inverseJoinColumns = @JoinColumn(name = "curso_id")
    )
    @JsonManagedReference
    private Set<Curso> cursos = new HashSet<>();
}
