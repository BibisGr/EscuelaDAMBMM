package progresa.escueladamb.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AlumnoDTO {
    private String nombre;
    private String apellidos;
    private String FechaNacimiento;
    private String dni;
    private String email;

}
