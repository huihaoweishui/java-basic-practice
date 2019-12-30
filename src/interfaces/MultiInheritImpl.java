package interfaces;

/**
 * @auther 薛晨
 * @date 2019/12/23
 * @time 10:35
 * @description 参考https://cloud.tencent.com/developer/article/1497709
 */
public class MultiInheritImpl implements InterfaceA, InterfaceB {
    @Override
    public String getNotDefaultMethod() {
//        return InterfaceA.super.getNotDefaultMethod();
        return "必须自己实现，因为没有默认方法";
    }

    /**
     * 需要显示覆盖 或者重新定义（选择使用哪个接口的方法，或者自己实现）
     *
     * @return
     */
    @Override // 注释或者不注释都可以
    public String getInterfaceName() {
        return InterfaceA.super.getInterfaceName();
//        return InterfaceB.super.getInterfaceName();
    }
}
