package generics;

/**
 * @auther 薛晨
 * @date 2019/12/30
 * @time 11:29
 * @description 泛型类和泛型接口
 */
//ClassA是普通类，应声明在第一位
public class GenericTypes<T extends ClassA & InterfaceB & InterfaceC> {
    private T t;

    public T getT() {
        return t;
    }

    public GenericTypes(T t) {
        this.t = t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
