package generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @auther 薛晨
 * @date 2019/12/30
 * @time 12:37
 * @description 必须继承或实现所有的类和接口
 */
public class SubClass extends ClassA implements InterfaceB, InterfaceC {

    public static <T extends Comparable<T>> int compare(T[] array, T e) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].compareTo(e) > 0) return 1;
        }
        return 0;
    }

    public <T extends Comparable<T>> void compare2(T[] array, T e) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i].compareTo(e));
        }
    }

    public List setList(List<?> list) {
        System.out.println(list);
        return list;
    }

    public static class ComparableEnabledClass implements Comparable<ComparableEnabledClass> {

       /* @Override
        public int compareTo(Object o) {
            return 0;
        }*/

        @Override
        public int compareTo(ComparableEnabledClass o) {
            return 0;
        }
    }

    public static void main(String[] args) {
        GenericTypes<SubClass> allImplied = new GenericTypes<>(new SubClass());
        SubClass t = allImplied.getT();
        ComparableEnabledClass[] a = new ComparableEnabledClass[5];
        a[0] = new ComparableEnabledClass();
//        t.compare2(a, a[0]);
        //注意List<Integer> List<String>都是List<?>的子类型，这和泛型的继承方式不一样
        t.setList(Arrays.asList("A", "B"));
        t.setList(Arrays.asList(1, 2));

        List<? super Integer> integerList = new ArrayList<>();
        List<? super Number> numberList = new ArrayList<>();
        integerList = numberList;
//        numberList=integerList;
        List<? extends Integer> intList = new ArrayList<>();
        List<? extends Number> numList = intList;  // OK. List<? extends Integer> is a subtype of List<? extends Number>
    }
}
