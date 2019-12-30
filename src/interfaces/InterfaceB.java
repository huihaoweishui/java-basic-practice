package interfaces;

/**
 * @auther 薛晨
 * @date 2019/12/23
 * @time 10:35
 * @description
 */
public interface InterfaceB {

    String getNotDefaultMethod();

    default String getInterfaceName() {
        return "B";
    }
}
