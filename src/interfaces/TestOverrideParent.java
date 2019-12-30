package interfaces;

/**
 * @auther 薛晨
 * @date 2019/12/23
 * @time 11:18
 * @description
 */
public class TestOverrideParent {
    private String name;

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
    public String methodA() {
        return "A";
    }

    public static String testStaticInherit(){
        return "HeHe";
    }
}
