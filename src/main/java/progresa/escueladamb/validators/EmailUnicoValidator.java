package progresa.escueladamb.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import progresa.escueladamb.dao.AlumnoRepository;

public class EmailUnicoValidator
        implements ConstraintValidator<EmailUnico, String> {
    @Autowired
    private AlumnoRepository alumnoRepository;

    @Override
    public boolean isValid(String email,
                           ConstraintValidatorContext context){
        return !alumnoRepository.existsByEmail(email);
    }
}
