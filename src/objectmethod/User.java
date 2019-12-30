package objectmethod;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther 薛晨
 * @date 2019/12/24
 * @time 12:37
 * @description
 */
public class User implements Cloneable {

    private String name;
    private Order order;
    List<Order> orderList;

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    private List<Order> deepCopy(List<Order> srcList) {
        List<Order> destList = new ArrayList<>();
        srcList.forEach(order -> destList.add(order));
        return destList;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        User cloneUser = (User) super.clone();

        Order cloneOrder = (Order) order.clone();//不同包下的子类中才能访问，当前order处在User类，无法调用Object的clone方法；如果想用clone方法，可以在order中重写
//        orderList.clone(); 显然List没有clone方法,因为它是接口，clone是实例方法，属于Object类的实例方法，还记得类和接口的新角度区别么。
        //只能自己实现克隆方法
        cloneUser.setOrderList(deepCopy(this.orderList));
        cloneUser.setOrder(cloneOrder);
        return cloneUser;
    }

    public static void main(String[] args) {
        User user = new User();
        user.setName("张三");
        Order originalOrder = new Order("张三的订单");
        user.setOrder(originalOrder);
        List<Order> list = new ArrayList<>();
        list.add(originalOrder);
        user.setOrderList(list);
        try {
            User cloneUser = (User) user.clone();
//            System.out.println(cloneUser.getName());
            cloneUser.setName("李四");
//            System.out.println(user.getName());
//            System.out.println(cloneUser.getName());
            Order cloneOrder = cloneUser.getOrder();
            System.out.println(cloneOrder.getOrderName());
            originalOrder.setOrderName("张三的订单名字改变了");
            //也就是说如果关联的类没有克隆的话，该类的变化会影响到被克隆出来的，他们的引用是指向同一个地方的，显然不允许
            System.out.println(cloneOrder.getOrderName());
            //重写user的clone方法，将关联的Order的clone方法也重写，这样就解决上面的问题
            System.out.println(cloneUser.getOrderList().size());
            list.clear();
            System.out.println(cloneUser.getOrderList().size());

        } catch (CloneNotSupportedException e) {
            System.out.println("user class not imply Cloneable interface");
        }
    }
}
