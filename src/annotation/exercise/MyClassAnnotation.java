package annotation.exercise;

import java.lang.annotation.*;

/**
 * @auther 薛晨
 * @date 2019/12/20
 * @time 19:21
 * @description
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyClassAnnotation {
    String className();

    String description() default "对应的表名字";
}
