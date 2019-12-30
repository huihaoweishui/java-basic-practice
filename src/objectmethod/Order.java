package objectmethod;

/**
 * @auther 薛晨
 * @date 2019/12/24
 * @time 12:38
 * @description
 */
public class Order implements Cloneable{
    private String orderName;

    public Order(String orderName) {
        this.orderName = orderName;
    }

    public void setOrderName(String name) {
        this.orderName = name;
    }

    public String getOrderName() {
        return orderName;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Order hehe = new Order("例子");
        Object clone = hehe.clone();
        User a = new User();
        Object clone1 = a.clone();
    }
}
