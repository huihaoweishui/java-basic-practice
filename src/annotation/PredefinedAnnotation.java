package annotation;

import iterate_critera_consumer.Person;

/**
 * @auther 薛晨
 * @date 2019/12/3
 * @time 11:22  java预定义注解: 1、修饰java语言本身的注解  @Deprecated @Override @SuppressWarnings @FunctionalInterface @SafeVarargs
 * 2、源注解(修饰注解的注解) @Retention @Documented @Target @Inherited @Repeatable
 * @description
 */
@RepeatableAnnotationMarkedAnnotation
@RepeatableAnnotationMarkedAnnotation
//@Deprecated
@Deprecated
public class PredefinedAnnotation extends Person {

    @FunctionalInterface
    interface funInterface {
        void test();
    }

    /**
     * @deprecated i do not like name
     */
    @Deprecated
    private String name;

    private int age;

    public PredefinedAnnotation(String name, int age, String email) {
        super(name, age, email);
    }

    @Override
    public int getAge() {
        return age * 2;
    }

    @Override
    @SuppressWarnings("deprecation ")
    //加不加上面的注解看看效果 deprecation 不是随便的字符传 rawtypes unchecked等
    public String getName() {
        return name;
    }

    public static void main(String[] args) {
        PredefinedAnnotation annotation = new PredefinedAnnotation("", 2, "");
        @SuppressWarnings("deprecation ")
        //加不加上面的注解看看效果
                String name = annotation.name;
    }
}
