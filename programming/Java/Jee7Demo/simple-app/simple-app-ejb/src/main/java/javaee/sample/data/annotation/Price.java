package javaee.sample.data.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Constraint(validatedBy = {})
@NotNull(message = "price is a required field")
@Min(value = 0, message = "price has to be greater than 0")
@Documented
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Price {

	String message() default "price has to be greater than 0";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
