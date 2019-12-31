package generics;

/**
 * @auther 薛晨
 * @date 2019/12/31
 * @time 14:50
 * @description
 */
public class Node<T> {
    public T data;

    public Node(T data) {
        this.data = data;
    }

    public void setData(T data) {
        System.out.println("Node.setData");
        this.data = data;
    }
}
