package access.a;

/**
 * @auther 薛晨
 * @date 2019/12/24
 * @time 15:06
 * @description
 */
public class ChildClassB extends ParentClass {

    public static void main(String[] args) {
        ParentClass childClass = new ChildClass();
        childClass.returnName();
        ParentClass childClass2 = new ChildClassB();
        childClass2.returnName();
    }
}
