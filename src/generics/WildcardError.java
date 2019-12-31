package generics;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * @auther 薛晨
 * @date 2019/12/31
 * @time 16:07
 * @description
 */
public class WildcardError {
    public List<?> list;

    void foo(List<?> i) {
//        i.set(0, i.get(0));
        fooHelper(i);
        this.list=i;
    }

    // Helper method created so that the wildcard can be captured
    // through type inference.
    private <T> void fooHelper(List<T> l) {
        l.set(0, l.get(1));
    }

    public static void main(String[] args) {
        WildcardError a = new WildcardError();
        List<? extends Serializable> hehe1 = Arrays.asList("hehe", 2, true);
        List<Integer> list = Arrays.asList(1, 2, 3);
        a.foo(hehe1);
        a.list.forEach(hehe-> System.out.println(hehe));
        a.foo(list);
        a.list.forEach(hehe-> System.out.println(hehe));

    }
}
