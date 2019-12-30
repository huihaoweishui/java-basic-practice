package access.a;

/**
 * @auther 薛晨
 * @date 2019/11/29
 * @time 10:04
 * @description
 */
public class ChildClass extends ParentClass {

    public static void main(String[] args) {
        ParentClass childClass = new ChildClass();
        childClass.returnName();
    }
}
