package nested_class;

/**
 * @auther 薛晨
 * @date 2019/12/21
 * @time 17:29
 * @description
 */
public class ChildClassExtendNested extends NestedClass {

    public int getAgeFromParentNestedClass() {
//        this.outAge;
        InnerClass innerClass = new InnerClass();
        return innerClass.getOutAge();
    }

    public static void main(String[] args) {
        System.out.println(new ChildClassExtendNested().getAgeFromParentNestedClass());
    }
}
