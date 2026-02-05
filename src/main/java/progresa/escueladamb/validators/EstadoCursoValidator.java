package progresa.escueladamb.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import progresa.escueladamb.dto.CursoDTO;

import java.time.LocalDate;

public class EstadoCursoValidator
        implements ConstraintValidator<EstadoCursoValido, CursoDTO> {
    @Override
    public boolean isValid(CursoDTO cursoDTO,
                           ConstraintValidatorContext context) {
        LocalDate hoy = LocalDate.now();
        if (cursoDTO.getEstado() == EstadoCurso.CURSANDO){
            return !hoy.isBefore(cursoDTO.getFechaInicio()) &&
                    !hoy.isAfter(cursoDTO.getFechaFin());
        }
        if(cursoDTO.getEstado() == EstadoCurso.ABANDONADO){
//            return 'El estudiante ha abandonado el curso, por lo que no se requiere una fecha específica';
            return false;
        }
        if(cursoDTO.getEstado() == EstadoCurso.APROBADO){
//            return 'El estudiante ha aprobado el curso, por lo que no se requiere una fecha específica';
            return false;
        }

        if(cursoDTO.getEstado() == EstadoCurso.SUSPENDIDO){
//            return 'El estudiante ha suspendido el curso, por lo que no se requiere una fecha específica';
            return false;
        }

        return  true;
    }

}
