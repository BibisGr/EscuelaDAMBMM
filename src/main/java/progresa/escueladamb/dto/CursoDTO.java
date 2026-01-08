package progresa.escueladamb.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CursoDTO {
    private String nombre;
    private String descripcion;
    private String fechaInicio;
    private String fechaFin;
    private Number creditos;
}
