package Annotations;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

@Documented
@Retention(RUNTIME)
public @interface problemDeff {
	   String author() default "Reni";
	   int number(); 
	   String dateSolved();
	   String deff();
	   String notes() default "";
}
