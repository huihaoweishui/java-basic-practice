package interfaces;

/**
 * @auther 薛晨
 * @date 2019/12/23
 * @time 11:16
 * @description 测试继承父类的方法，不写override会怎么样
 */
public class TestOverrideAndRulesForSameMethod extends TestOverrideParent {
    private String name;

    public static String testStaticInherit() {
        return "HaHa";
    }

    //子类不能用实例方法覆盖父类的静态方法，因为java允许使用实例对象.静态方法调用方法，所以会产生多态的错觉
    /*public  String testStaticInherit(){
        return "HaHa";
    }*/
    //子类也不能用静态方法覆盖父类的实例方法。
    /*public static String methodA() {
        return "B";
    }*/
    @Override
    public String methodA() {
        return "B";
    }


    @Override
    public String getName() {
        System.out.println("子类的" + name);
        System.out.println("父类的" + super.getName());
        return name;
    }

    public static void main(String[] args) {
        //多态的效果依然是有的，也就是说@override只是为了让编译器去检查，是否真的父类有同样签名的方法，也反应了@override注解只在源代码有效@Retention(RetentionPolicy.SOURCE)
        TestOverrideParent child = new TestOverrideAndRulesForSameMethod();
        System.out.println(child.methodA());
        //静态方法是不会产生多态的(说明不能被子类继承到)，因为静态方法属于类，
        System.out.println(child.testStaticInherit());
        //调用父类的setName,name自然是保存在父类的对象之中
        child.setName("child");
        System.out.println(child.getName());
        System.out.println(child.methodA());
    }
}
