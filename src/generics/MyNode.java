//package generics;
//
///**
// * @auther 薛晨
// * @date 2019/12/31
// * @time 14:51
// * @description
// */
//public class MyNode extends Node<Integer> {
//    public MyNode(Integer data) {
//        super(data);
//    }
//
//    public void setData(Integer data) {
//        System.out.println("MyNode.setData");
//        super.setData(data);
//    }
//
//    public static void main(String[] args) {
//        //erase
////        public class Node {
////
////            public Object data;
////
////            public Node(Object data) { this.data = data; }
////
////            public void setData(Object data) {
////                System.out.println("Node.setData");
////                this.data = data;
////            }
////        }
////
////        public class MyNode extends Node {
////
////            public MyNode(Integer data) { super(data); }
////
////            public void setData(Integer data) {
////                System.out.println("MyNode.setData");
////                super.setData(data);
////            }
////        }
//        MyNode mn = new MyNode(5);
//        Node n = mn;            // A raw type - compiler throws an unchecked warning
//        n.setData("Hello");
//        Integer x = mn.data;    // Causes a ClassCastException to be thrown. 运行时异常
//        //  上述代码 erase 的过程也就是java 编译的过程， 并不是真实代码 ，相当于下面的代码，但虽然上述代码编译通过了，但是运行结果是不成功的，
////        MyNode mn2 = new MyNode(5);
////        Node n2 = (MyNode) mn2;         // A raw type - compiler throws an unchecked warning  隐式转换
////        n2.setData("Hello");
////        Integer x2 = (String) mn2.data; // Causes a ClassCastException to be thrown. 强制cast
//
//        MyNode mn3 = new MyNode(5);
//        Node<Integer> n3 = mn3;            // A raw type - compiler throws an unchecked warning
//        n3.setData("Hello");  // 所以还是要加泛型啊
//        Integer x3 = mn3.data;
//    }
//}
