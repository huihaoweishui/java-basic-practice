package iterate_critera_consumer;

import com.sun.org.glassfish.gmbal.Description;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @auther 薛晨
 * @date 2019/12/2
 * @time 9:36 程序中经常遇到的操作：遍历查找集合中符合条件的对象，并将对象的信息取出来/操作(一步一步简化、抽象封装变化至极简、复用巅峰，将实现特定逻辑的代码从方法中延迟到实现
 * 好的代码不是一蹴而就的！)
 * @description
 */
public class IteratePersonApproachesTest {
    //将不大于mostAge的人打印出来(如果想要小于某个年龄的人、或者通过性别找人，是不是每一种情况都要重写一个方法呢)
    @Description("易碎的代码：Peron类结构变了比如 age的类型变了；比较的算法变了等都会导致下面这个方法调整" +
            "(在设计模式中的说法就是没有封装变化)" +
            "那么变化的地方在哪里呢？在这里就是查询的标准")
    public void approach1(List<Person> personList, int mostAge) {
        for (Person person : personList) {
            if (person.getAge() <= mostAge) {
                System.out.println(person.getName());
            }
        }
    }

    //定义查询标准的接口 把变化封装起来
    interface CheckPerson {
        boolean test(Person person);
    }

    public void approach2(List<Person> personList, CheckPerson personChecker) {
        for (Person person : personList) {
            if (personChecker.test(person)) {
                System.out.println(person.getName());
            }
        }
    }


    public void approach3(List<Person> personList, Predicate<Person> predicate) {
        for (Person person : personList) {
            if (predicate.test(person)) {
                System.out.println(person.getName());
            }
        }
    }

    public void approach4(List<Person> personList, Predicate<Person> predicate, Consumer<Person> consumer) {
        for (Person person : personList) {
            if (predicate.test(person)) {
                //return void
                consumer.accept(person);
            }
        }
    }

    public void approach5(List<Person> personList, Predicate<Person> predicate, Function<Person, String> mapper, Consumer<String> consumer) {
        for (Person person : personList) {
            if (predicate.test(person)) {
                //return value
                String data = mapper.apply(person);
                consumer.accept(data);
            }
        }
    }

    public <R> void approach5Generic(List<Person> personList, Predicate<Person> predicate, Function<Person, ? extends R> mapper, Consumer<R> consumer) {
        for (Person person : personList) {
            if (predicate.test(person)) {
                //return value
                R data = mapper.apply(person);
                consumer.accept(data);
            }
        }
    }

    public <T, R> void approach6(List<T> personList, Predicate<T> predicate, Function<T, R> mapper, Consumer<R> consumer) {
        for (T t : personList) {
            if (predicate.test(t)) {
                //return value
                R data = mapper.apply(t);
                consumer.accept(data);
            }
        }
    }

    public static void main(String[] args) {
        List<Person> personList = Arrays.asList(new Person("张三", 18, "zs@163.com"),
                new Person("李四", 20, "ls@163.com"),
                new Person("王五", 22, "ww@163.com"),
                new Person("赵六", 24, "zl@163.com"));
        IteratePersonApproachesTest test = new IteratePersonApproachesTest();
        //方法一
        test.approach1(personList, 20);
        //方法二
        //使用局部内部类实现条件接口
        class PersonChecker implements CheckPerson {

            @Override
            public boolean test(Person person) {
                return person.getAge() <= 20;
            }
        }
        PersonChecker checker = new PersonChecker();
        test.approach2(personList, checker);
        //方法三 如果这个标准只使用单次 可以使用匿名内部类替代局部内部类
        // (好处是1、免去实现类的定义 2、如果要切换查询逻辑 则要为每个条件分别定义实现类)
        test.approach2(personList, new CheckPerson() {
            @Override
            public boolean test(Person person) {
                return person.getAge() <= 20;
            }
        });
        //方法四 CheckPerson同时也是函数式接口，所以可以进一步用lambda表达式替换匿名内部类
        test.approach2(personList, person -> person.getAge() <= 20);
        //相当于CheckPerson p = person -> person.getAge()<=20;
        //到目前为止 我们只需要定义一个函数式接口，然后在需要实现的时候传入实现比较方法的lambda表达式即可将想要的对象过滤出来
        //再看一下CheckPerson接口，这个接口简直太简单了(还很通用)，甚至不想自己再定义一个，为此JDK内置了这样的接口 java.util.function.Predicate<T>
        //可以查看源码 知道它就有一个boolean test(T t)的方法 满足我们的需求，因此我们连CheckPerson接口都无需自己定义了。
        test.approach3(personList, person -> person.getAge() <= 20);
        //到目前为止 我们封装了条件的变化，再看看approach3方法 看看我们还能使用lambda表达式在别的地方么
        //现在我们只是单纯的打印人名，如果我们想获取email、获取性别，甚至全部信息怎么办？是不是又要分别定义方法？又回到了一开始遇到的条件多样性问题
        //解决方案就是和之前一样 封装变化，显然此处的变化是：如何处理满足条件的对象。java.util.function.Consumer<T> 登场！
        test.approach4(personList, person -> person.getAge() <= 20, person -> System.out.println(person.getEmail()));
        test.approach4(personList, person -> person.getAge() <= 20, person -> person.getSex());
        test.approach4(personList, person -> person.getAge() <= 20, Person::getSex); // lambda进一步 方法引用
        //TODO 如果想获取返回值使用java.util.Function<T,R>,不过一开始个人觉得通用性不是很好，犯了本主题的错误(可能在特定场合下可以使用,比如方法要返回名字集合、整个person实例集合等)，
        // 比如我一开始定义的返回类型是String，如果想返回int类型还是要重新定义一个方法；另外返回值返回来你不能判断是什么哪个字段或其他数据，进而不能做相应操作，
        // 方法七提供解决了这个问题的思路：泛型(可以规范参数类型) <R> Stream<R> map(Function<? super T, ? extends R> mapper); 这样就无需定义每种方法返回特定类型了
        //方法五
        test.approach5(personList, person -> person.getAge() <= 20, person -> person.getEmail(), email -> System.out.println(email));
        test.approach5(personList, person -> person.getAge() <= 20, person -> person.getName(), name -> System.out.println(name));
        //五变体
        test.approach5Generic(personList, person -> person.getAge() <= 20, person -> person.getAge(), name -> System.out.println(name));
        //test.approach5(personList, person -> person.getAge() <= 20, Person::getEmail, System.out::println);
        //目前为止 我们可以对Person类进行按条件查询，因为这种需求程序中到处都有，能否将Person类也通用化->泛化，这样整个方法与具体类无关，只有使用者知道自己在干什么、要什么
        List<Person2> personList2 = Arrays.asList(new Person2("张三", 18, "zs@163.com"),
                new Person2("李四", 20, "ls@163.com"),
                new Person2("王五", 22, "ww@163.com"),
                new Person2("赵六", 24, "zl@163.com"));
        //方法六
        test.approach6(personList2, person -> person.getAge() <= 20, person -> person.getEmail(), email -> System.out.println(email));
        //方法七 jdk提供的聚合操作，这种操作不直接操作原数据对象，因此不会影响原数据对象，stream()相当于拷贝了原数据对象。
        personList.stream().filter(person -> person.getAge() <= 20).map(person -> person.getEmail()).forEach(s -> System.out.println(s));
        personList.stream().filter(person -> person.getAge() <= 20).map(person -> person.getAge()).forEach(s -> System.out.println(s));
    }
}
