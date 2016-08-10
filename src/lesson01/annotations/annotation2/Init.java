package lesson01.annotations.annotation2;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface Init {
    boolean suppressException() default false;
}
