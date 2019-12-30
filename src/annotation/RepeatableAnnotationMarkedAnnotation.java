package annotation;

import java.lang.annotation.Repeatable;

/**
 * @auther 薛晨
 * @date 2019/12/3
 * @time 12:54
 * @description
 */
@Repeatable(value = RepeatableAnnotationMarkedAnnotation.ContainerAnnotation.class)
public @interface RepeatableAnnotationMarkedAnnotation {

    @interface ContainerAnnotation {
        RepeatableAnnotationMarkedAnnotation[] value();
    }
}
