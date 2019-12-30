package interfaces;

/**
 * @auther 薛晨
 * @date 2019/12/23
 * @time 10:34
 * @description
 */
public interface InterfaceA {

    String getNotDefaultMethod();
    default String getInterfaceName() {
        return "A";
    }
}
