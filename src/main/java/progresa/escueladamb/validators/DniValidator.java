package progresa.escueladamb.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DniValidator implements ConstraintValidator<DniValido, String> {
    private static final String letras= "TRWAGMYFPDXBNJZSQVHLCKE";
    @Override
    public boolean isValid(String dni,
                            ConstraintValidatorContext context){
        if (dni==null || dni.length() !=9){
            return false;
        }
        int numero = Integer.parseInt(dni.substring(0,8));
        char letraCorrecta = letras.charAt(numero %23);
        return dni.charAt(8) == letraCorrecta;
    }
}
