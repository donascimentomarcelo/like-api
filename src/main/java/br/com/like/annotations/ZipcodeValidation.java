package br.com.like.annotations;

import br.com.like.constants.Constants;
import br.com.like.validations.ZipcodeValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = ZipcodeValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface ZipcodeValidation {

    String message() default Constants.VALIDATION_ERROR;
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
