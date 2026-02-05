package progresa.escueladamb.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import progresa.escueladamb.entity.Curso;
import progresa.escueladamb.validators.DniValido;
import progresa.escueladamb.validators.EmailUnico;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AlumnoDTO {
    @NotBlank
    @Size(min = 1, max = 100)
    private String nombre;
    @NotBlank
    @Size(min = 2, max = 200)
    private String apellidos;
    @NotBlank

    private String FechaNacimiento;
    @Pattern(
            regexp = "^[0-9]{8} [A-Z]$" , // pattern para DNI
//            regexp = "^[A-Z]$ [0-9]{8} [A-Z]$",  // pattern para NIE y NIF
            message = "El DNI debe tener 8 dígitos seguidos de un espacio y una letra mayúscula"
    )
    @DniValido
    private String dni;

    @NotBlank
    @Email
    @EmailUnico
    private String email;

    private List<Curso> cursos;

}
