package rodionomelin_task2_annotations;

import java.lang.annotation.*;

import static rodionomelin_task2_annotations.Colors.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({
        ElementType.METHOD, //только для методов;
        ElementType.TYPE    //только для классов;
})
public @interface Print {
    String style() default "";
    String color() default WHITE;
}