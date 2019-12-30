package access;

/**
 * @auther 薛晨
 * @date 2019/12/24
 * @time 15:11
 * @description 直接使用java.lang包中的Object来阐述protected访问权限
 */
public class ObjectMethodAccessTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        ObjectMethodAccessTest objectMethodAccessTest = new ObjectMethodAccessTest();
        Object clone = objectMethodAccessTest.clone();
        ChildClassC childClassC = new ChildClassC();
//        childClassC.clone();  //protected访问权限真的很特殊，
// 只能在子类中并且是该子类对象才能访问，非当前子类的对象都无法访问
        //想想为什么 假如a包中有父类的一个protected属性，b包是项目A组的包，他继承了a包的父类
        // 他在他的模块中使用到了protected属性
        //此时项目B组有了新包c，也继承了a包的父类，并且依赖A组的b包(此时B组相当于A组的客户端)，
        //如果在c包的子类中实例化A组的子类，并且可以允许修改它的protected属性，
        // 这样不就是允许客户端直接修改服务端的属性值么，我们知道封装的目的就是不要让类库使用者破坏内部的属性，
        // 而是通过暴露出方法来让客户端使用。所以这就是为什么protected修饰的时候，不同包只能由当前的子类对象去
        // 访问父类的protected属性或方法
    }
}
