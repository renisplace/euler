package Annotations;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

@Documented
@Retention(RUNTIME)
public @interface methodDeff {
	   String deff() default "";
	   String validParms() default "not defined";
	   String notes() default "";
}
