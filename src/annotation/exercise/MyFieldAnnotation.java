package annotation.exercise;

import java.lang.annotation.*;

/**
 * @auther 薛晨
 * @date 2019/12/20
 * @time 19:26
 * @description
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyFieldAnnotation {
    String fieldName();

    String description();
}
