package strings;

/**
 * @auther 薛晨
 * @date 2019/12/30
 * @time 10:27
 * @description 可以看源码系列 TODO
 */
public class StringBuilderTest {
    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder("hello");
        System.out.println(builder.capacity());
        System.out.println(builder.length());
        builder.setLength(3);
        System.out.println("---------------截取后---------");
        System.out.println(builder.capacity());
        System.out.println(builder.length());
        System.out.println(builder);
        builder.setLength(22);
        System.out.println("--------扩展后-----");
        System.out.println(builder.capacity());
        System.out.println(builder.length());
        System.out.println(builder);
        builder.ensureCapacity(2);
        System.out.println("-------ensure------");
        builder.setLength(1);
        System.out.println(builder.capacity());
        System.out.println(builder.length());
    }
}
