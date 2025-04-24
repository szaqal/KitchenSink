package javaee.sample.data.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;


@Constraint(validatedBy = {})
@NotNull(message = "title is a required field")
@NotEmpty
@Size(min = 1, max = 100)
@Documented
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Artist {
	
	String message() default "Artist may not be empty and longer than 100 chars";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
