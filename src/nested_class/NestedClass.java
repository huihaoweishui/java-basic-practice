package nested_class;

/**
 * @auther 薛晨
 * @date 2019/12/2
 * @time 12:59
 * @description 迭代器模式
 */
public class NestedClass {

    private int outAge = 1;

    private static int staticAge;

    private static String getOutString() {
        return "hello world";
    }

    static class StaticNestedClass {
        private String name;

        public static int getStaticAge() {
            return staticAge;
        }

        public String getName() {
            return getOutString();
        }
    }

    class InnerClass {
        //        private static int age;
        private int age;

        public int getOutAge() {
            return NestedClass.this.outAge;
        }
    }

    public static void main(String[] args) {
        //创建方式 反应了静态内部类和非静态内部类与外部类的关系(一个是类、一个是类的实例)
        // 进而关系到内部类的属性是否是非静态、内部类对外部类属性的访问权限
        NestedClass outClass = new NestedClass();
        InnerClass innerClass = outClass.new InnerClass();
        NestedClass.StaticNestedClass staticNestedClass = new NestedClass.StaticNestedClass();
        innerClass.getOutAge();
        staticNestedClass.getName();
    }
}


