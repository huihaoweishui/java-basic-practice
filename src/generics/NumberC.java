//package generics;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
///**
// * @auther 薛晨
// * @date 2019/12/30
// * @time 17:34
// * @description https://docs.oracle.com/javase/tutorial/java/generics/wildcards.html 官方说了通配符适合使用的地方，不是实例化，而是当作方法的参数类型等
// * 下面的例子暴露出的很多问题都印证官方的建议
// */
//public class NumberC extends NumberB {
//    //List<NumberB> List<NumberA> 能处理这两种类型
//    public static void test(List<? super NumberB> bList) {
//
//    }
//
//    //List<NumberC>  List<NumberB> List<NumberA> 能处理这三种类型 所以可以cList = bList;包含
//    public static void testc(List<? super NumberC> cList) {
//        cList.forEach(numberc -> System.out.println(numberc.getClass().getName()));
//    }
//
//    public static void main(String[] args) {
//        //1、List<? super XX类> a = new ArrayList<>(); 虽然看上去定义了a能存放XX类及其超类(@1)，但我们知道
//        //java多态机制只能使用父引用指向子类对象，比如List<Parent> b = new ArrayList<>();能放Parent及其子类
//        // 如：b.add(new Child());b.add(new Parent());完全没问题，不可能说List<Child> c = new ArrayList<>();
//        //c.add(new Child());c.add(new Parent()) ；所以@1只能是看上去，实际是不能放的，不要望文生义,这是第一点；第二点，那么List<? super XX类>的
//        //含义到底是什么？只能是List<? super XX类> 能接受 List<XX类>以及 List<XX的超类>因为这两者都是前者的子类，当List<? super XX类>
//        //作为方法参数时尤为明显，如上面的test方法(@2)。第三点，其实在实例化的场景下super限定了上边界和@1是相呼应的
//        List<? super NumberB> bList = new ArrayList<>();
//bList.add(null);
//bList.clear();
//
//        bList.add(new NumberA());
//        bList.add(new NumberB());
//        bList.add(new NumberC());
//        List<? super NumberC> cList = new ArrayList<>();
//        cList.add(new NumberA());
//        cList.add(new NumberB());
//        cList.add(new NumberC());
//        cList = bList;
////        bList =cList;
//        // 证明@2
//        List<NumberA> lista = new ArrayList<>();
//        List<NumberB> listb = new ArrayList<>();
//        List<NumberC> listc = new ArrayList<>();
//
//        test(lista);
//        test(listb);
//        test(listc);
//
//        testc(lista);
//        testc(listb);
//        testc(listc);
//        testc(bList);
//
//        Arrays.stream()
//        List<? extends NumberB> bList2 = new ArrayList<>();
//        bList2.add(new NumberB());
//        bList2.add(new NumberA());
//        bList2.add(new NumberC());
//        List<? extends NumberC> cList2 = new ArrayList<>();
//        cList2.add(new NumberC());
//        cList2.add(new NumberA());
//        cList2.add(new NumberB());
//        bList2 = cList2;
//
//        List<Object> hehe = new ArrayList<>();
//        List<String>  haha = new ArrayList<>();
//        hehe=haha;
//        haha= hehe;
//    }
//}
