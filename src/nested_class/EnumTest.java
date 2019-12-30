package nested_class;

/**
 * @auther 薛晨
 * @date 2019/12/3
 * @time 10:54
 * @description
 */
public enum EnumTest {
    MONDAY(1), SUNDAY(2);
    private final int number;

    EnumTest(int number) {
        this.number = number;
    }

    public static void main(String[] args) {
//        EnumTest enumTest = new EnumTest(3);
        for (EnumTest value : EnumTest.values()) {
            System.out.println(value.number);
        }
        EnumTest monday = EnumTest.MONDAY;
        System.out.println(monday.name().equals("MONDAY"));
    }
}
