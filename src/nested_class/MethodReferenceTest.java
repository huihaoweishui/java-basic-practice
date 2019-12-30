package nested_class;

import iterate_critera_consumer.Person;

import java.util.*;
import java.util.function.Supplier;

/**
 * @auther 薛晨
 * @date 2019/12/2
 * @time 14:34
 * @description
 */
public class MethodReferenceTest {

    public int compareByAgeByInstance(Person a, Person b) {
        return a.getBirthday().compareTo(b.getBirthday());
    }

    static class PersonAgeComparator implements Comparator<Person> {
        public int compare(Person a, Person b) {
            return a.getBirthday().compareTo(b.getBirthday());
        }
    }

    public static <T, SOURCE extends Collection<T>, DEST extends Collection<T>> DEST transferElements(
            SOURCE sourceCollection,
            Supplier<DEST> collectionFactory) {

        DEST result = collectionFactory.get();
        for (T t : sourceCollection) {
            result.add(t);
        }
        return result;
    }

    public static void main(String[] args) {
        MethodReferenceTest test = new MethodReferenceTest();

        Person[] personList = {new Person("张三", 18, "zs@163.com"),
                new Person("李四", 20, "ls@163.com"),
                new Person("王五", 22, "ww@163.com"),
                new Person("赵六", 24, "zl@163.com")};
        List<Person> personList1 = Arrays.asList(personList);
        Arrays.sort(personList, new PersonAgeComparator());
        //静态方法引用
        Arrays.sort(personList, (p1, p2) -> Person.compareByAge(p1, p2));
        Arrays.sort(personList, Person::compareByAge);
        //实例方法引用
        Arrays.sort(personList, test::compareByAgeByInstance);
        Arrays.sort(personList, (p1, p2) -> {
            return p1.getBirthday().compareTo(p2.getBirthday());
        });
        Arrays.sort(personList, Comparator.comparing(Person::getBirthday));
        // 构造器方法引用
        Set<Person> sets = MethodReferenceTest.transferElements(personList1, () -> new HashSet<>());
        Set<Person> sets2 = MethodReferenceTest.transferElements(personList1, HashSet::new);
    }
}
