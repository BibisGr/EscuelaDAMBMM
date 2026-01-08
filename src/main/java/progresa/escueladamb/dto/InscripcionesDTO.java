package progresa.escueladamb.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InscripcionesDTO {
    private String estudianteid;
    private String cursoid;
    private String fechaInicio;
    private String fechaFin;
    private String estado;
    private Number nota;
}
