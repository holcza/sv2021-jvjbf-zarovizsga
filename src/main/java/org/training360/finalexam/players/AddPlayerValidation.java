package org.training360.finalexam.players;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy = AddPlayerValidator.class)
public @interface AddPlayerValidation {

    String message() default "Invalid request, the player has already a team";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
