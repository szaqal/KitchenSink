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
@NotNull(message = "genre is a required field")
@Pattern(regexp = "(pop|rock|metal|rap|other)", message = "Must match one of pop,rock,metal,rap,other")
@Size(min = 1, max = 100)
@Documented
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Genre {

	String message() default "Genre may not be empty and longer than 100 chars";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
