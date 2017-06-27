package javaee.sample.data.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Constraint(validatedBy = {})
@NotNull
@Size(min = 1, max = 25)
@Pattern(regexp = "[^0-9]*", message = "Must not contain numbers")
@Documented
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface RequiredTextOnly {

	String message() default "Field is required and must be text-only";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
