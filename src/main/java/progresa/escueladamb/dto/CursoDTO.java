package progresa.escueladamb.dto;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import progresa.escueladamb.entity.Alumno;
import progresa.escueladamb.validators.EstadoCurso;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CursoDTO {
    @NotBlank
    @Size(min = 1, max = 100)
    private String nombre;
    @NotBlank
    @Size(min = 1, max = 500)
    private String descripcion;

    @NotNull
    private LocalDate fechaInicio;
    @NotNull
    private LocalDate fechaFin;

    @NotNull
    @Min(1)
    @Max(100)
    private Number creditos;

    @Enumerated(EnumType.STRING)
    private EstadoCurso estado;

    private List<Alumno> alumnos;
}
