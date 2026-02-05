package progresa.escueladamb.validators;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = DniValidator.class)
@Target({FIELD, PARAMETER})
@Retention(RUNTIME)
public @interface DniValido {
    String mensaje() default "la letra del DNI no es correcta";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
