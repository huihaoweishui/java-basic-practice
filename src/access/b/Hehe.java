package access.b;

import access.a.ChildClass;
import access.a.ParentClass;

/**
 * @auther 薛晨
 * @date 2019/11/29
 * @time 10:14
 * @description
 */
public class Hehe extends ParentClass {
    {
        String s = returnName();
        System.out.println(s);
        ParentClass childClass2 = new ChildClass();
//        childClass2.returnName();
        ChildClass childClass = new ChildClass();
//        childClass.returnName();
    }

    // TODO 解释一下为什么 protected最烦:在同包下没啥问题，‘在其他包下只能被子类访问’的意思是真的还就是这个意思！！！就是下面代码最后的例子
    //Hehe hehe = new Hehe();
    //hehe.returnName(); protected属性和方法在其他包下只能是子类引用类型的对象才能访问到(父类引用也会失效)；
    // 并且在其他包下无法跨包访问跨的包下的所有类的除public方法（理解类访问权限就能明白）
    //总结一下：假设能声明一个引用类型(类定义权限通过) 该引用能不能引用到该引用类型的方法取决于1这个类型的类定义所在的包 2、当前使用的这个类所处的包 3、引用想调用的方法的访问修饰符
    public static void main(String[] args) {
        //在当前包b下面还能访问到ParentClass类，如果将ParentClass类的定义default，那么在b包下甚至连ParentClass这个类字眼都无法出现 感受一下理解一下
        ParentClass parentClass = new ParentClass();
//        parentClass.returnName();
        ParentClass childClass2 = new ChildClass();
//        childClass2.returnName();
        ChildClass childClass = new ChildClass();
//        childClass.returnName();
        Hehe hehe = new Hehe();
        hehe.returnName();

    }
}
