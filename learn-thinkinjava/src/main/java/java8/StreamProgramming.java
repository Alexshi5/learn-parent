package java8;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Java8的流式编程
 */
public class StreamProgramming {
    //参考于：https://my.oschina.net/thinwonton/blog/2992751

    /**
     * 什么是Stream?
     *
     * 1、Stream API借助Lambda表达式，提供串行和并行两种模式进行汇聚操作，并行模式能够充分利用多核处理器的优势，使用fork/join来拆分
     * 任务和加速处理过程；
     * 2、流由三部分构成：数据源、中间操作、数据操作，每次转换时原有的Stream对象不变，返回一个新的Stream对象(可以多次转换)，这就允许
     * 对其操作像链条一样排列，变成一个管道。
     */
    @Test
    public void example1(){
        final List<String> stringList = Arrays.asList("Tom","Jack","Alice","Lina","Pony");

        //串行流
        long count1 = stringList.stream()
                .filter(s -> {
                    System.out.println(Thread.currentThread().getId() + "==" + Thread.currentThread().getName());
                    return s.length() > 3;
                })
                .count();
        System.out.println(count1);

        //并行流
        long count2 = stringList.parallelStream()
                .filter(s -> {
                    System.out.println(Thread.currentThread().getId() + "==" + Thread.currentThread().getName());
                    return s.length() > 3;
                })
                .count();
        System.out.println(count2);
    }

    /**
     * 流的分类
     *
     * 中间操作：返回一个新的Stream。中间操作都是惰性的，它们不会对数据源执行任何操作，仅仅是创建一个新的Stream。
     * 在终端操作执行之前，数据源的遍历不会开始。
     *
     * 终端操作：遍历流并生成结果或者副作用。执行完终端操作后，Stream就会被“消费”掉，如果想再次遍历数据源，则必须重新创建新的Stream。
     * 大多数情况下，终端操作的遍历都是即时的——在返回之前完成数据源的遍历和处理，只有iterator()和spliterator()不是，
     * 这两个方法用于提供额外的遍历功能——让开发者自己控制数据源的遍历以实现现有Stream操作中无法满足的操作(实际上现有的Stream操作基本能满足需求，所以这两个方法目前用的不多)。
     */
    @Test
    public void example2(){

        //终端操作——非短路操作：forEach(), forEachOrdered(); reduce(), collect(), max(), min(), count(); toArray()

        //终端操作——短路操作：anyMatch(), allMatch(), noneMatch(); findFirst(), findAny()

        //中间操作——无状态：unordered(), filter(), map(), mapToInt(), mapToLong(), mapToDouble(), flatMap(), flatMapToInt(), flatMapToLong(), flatMapToDouble(), peek();

        //中间操作——有状态：distinct();  sorted();  limit(), skip()

        /**
         * 有状态和无状态的区别：
         * 有状态——就是有数据存储功能，线程不安全
         * 无状态——就是一次操作，不能保存数据，线程安全
         * 可参考：https://blog.csdn.net/f641385712/article/details/82020641
         */
    }

    /**
     * 终端操作——非短路操作：forEach
     * 对所有元素进行迭代处理，无返回值
     */
    @Test
    public void example3(){
        Arrays.asList(1,2,3,4,5).forEach(i -> System.out.println(i * i));
    }

    /**
     * 终端操作——非短路操作：reduce
     * 通过累加器对前面的序列进行累计操作，并最终返回一个值。累加器有两个参数，第一个是前一次累加的结果，第二个是前面集合的下一个元素。
     * 通过reduce可以实现avg sum max min count等操作
     */
    @Test
    public void example4(){
        List<String> stringList = Arrays.asList("S01","S02","S03");
        Optional<String> reduce = stringList.stream().reduce((x, y) -> {
            return x + "_" + y;
        });
        System.out.println(reduce.orElse("default")); //打印：S01_S02_S03
    }

    /**
     * 终端操作——非短路操作：collect
     * 它可以将流转化为其他形式，比如字符串、List、Set、Map等
     */
    @Test
    public void example5(){

        //拼接字符串
        String collect1 = Stream.of("S01", "S02", "S03")
                .collect(Collectors.joining("_"));
        System.out.println(collect1); //打印：S01_S02_S03

        //转List
        List<String> collect2 = Stream.of("S01", "S02", "S03")
                .collect(Collectors.toList());
        System.out.println(collect2.getClass().getSimpleName()); //打印：ArrayList

        //转Set
        Set<String> collect3 = Stream.of("S01", "S02", "S03")
                .collect(Collectors.toSet());
        System.out.println(collect3.getClass().getSimpleName()); //打印：HashSet

        //转Map
        Map<String, String> collect4 = Stream.of("S01", "S02", "S03")
                .collect(Collectors.toMap(
                        key -> key,
                        val -> val
                ));
        for(Map.Entry<String, String> map:collect4.entrySet()){
            System.out.println("key:" + map.getKey() + ",val:" + map.getValue());
        }
        //打印：
        //key:S02,val:S02
        //key:S01,val:S01
        //key:S03,val:S03
    }

    /**
     * 终端操作——短路操作：anyMatch()
     * 只要有一个元素满足传入的Predicate就返回ture，否则返回false。相当于逻辑运算符||
     */
    @Test
    public void example6(){
        boolean b = Stream.of("S01", "S02", "S03")
                .anyMatch(s -> s.contains("1"));
        System.out.println(b); //打印：true

        boolean b2 = Stream.of("S01", "S02", "S03")
                .anyMatch(s -> s.contains("4"));
        System.out.println(b2); //打印：false
    }

    /**
     * 终端操作——短路操作：allMatch
     * 必须要所有的元素都满足传入的Predicate才返回true，否则返回false。相当于逻辑运算符&&
     */
    @Test
    public void example7(){
        boolean b = Stream.of("S01", "S02", "S03")
                .allMatch(s -> s.startsWith("S"));
        System.out.println(b); //打印：true

        boolean b2 = Stream.of("S01", "S02", "S03")
                .allMatch(s -> s.endsWith("1"));
        System.out.println(b2); //打印：false
    }

    /**
     * 终端操作——短路操作：noneMatch
     * 所有元素均不满足传入的Predicate才返回true，否则返回false。
     */
    @Test
    public void example8(){
        boolean b = Stream.of("S01", "S02", "S03")
                .noneMatch(s -> s.startsWith("A"));
        System.out.println(b); //打印：true

        boolean b2 = Stream.of("S01", "S02", "S03")
                .noneMatch(s -> s.endsWith("1"));
        System.out.println(b2); //打印：false
    }

    /**
     * 中间操作——无状态：map()
     * 使用传入的Function对Stream中的所有对象进行处理，返回的Stream中的元素为处理后的结果元素。
     */
    @Test
    public void example9(){
        //平方
        Stream<Integer> integerStream = Stream.of(1, 2, 3)
                .map(i -> i * i);
        List<Integer> collect = integerStream.collect(Collectors.toList());
        collect.forEach(System.out::println); //打印：1 4 9
    }

    /**
     * 中间操作——无状态：flatMap()
     * map生成的是1:1映射，而flatMap则是1对多的映射
     */
    @Test
    public void example10(){
        Stream<List<Integer>> listStream = Stream.of(
                Arrays.asList(2),
                Arrays.asList(3, 4)
        );
        Stream<Integer> integerStream = listStream.flatMap(list -> list.stream());
        integerStream.map(i -> i * i).collect(Collectors.toList()).forEach(System.out::println); //打印：4 9 16
    }

    /**
     * 中间操作——无状态：filter()
     * filter对原始的Stream进行某项测试，通过测试的元素被留下来生成一个新的元素
     */
    @Test
    public void example11(){
        Stream.of("S01", "S02", "S03", "A04")
                .filter(s -> s.contains("S"))
                .collect(Collectors.toList())
                .forEach(System.out::println); //打印：S01 S02 S03
    }

    /**
     * 中间操作——无状态：peek()
     * peek跟forEach的作用类似。区别在于forEach会消费掉Stream中的元素，而peek不会，它的操作是惰性的。
     */
    @Test
    public void example12(){
        Stream.of("tom","jack","lina")
                .peek(s -> System.out.println("原来的值：" + s))
                .map(s -> s.toUpperCase())
                .peek(s -> System.out.println("现在的值：" + s))
                .collect(Collectors.toList());
        //打印结果如下：
        //原来的值：tom
        //现在的值：TOM
        //原来的值：jack
        //现在的值：JACK
        //原来的值：lina
        //现在的值：LINA
    }

    /**
     * 中间操作——有状态：limit()和skip()
     * limit截取流前面几个元素，skip跳过流前面几个截取后面的元素
     */
    @Test
    public void example13(){
        //截取前面2个元素
        Stream.of('a','b','c','d','e').limit(2).forEach(System.out::println); //打印：a b

        //跳过前面3个元素
        Stream.of('a','b','c','d','e').skip(3).forEach(System.out::println); //打印：d e
    }

    /**
     * 中间操作——有状态：distinct()
     * 对流中的元素去重
     */
    @Test
    public void example14(){
        Stream.of('a','b','c','b','b').distinct().forEach(System.out::println); //打印：a b c
    }

    /**
     * 中间操作——有状态：sorted()
     * 对流中的元素进行排序
     */
    @Test
    public void example15(){
        //默认，从小到大排序
        Stream.of(9,5,8,3,1)
                .sorted()
                .forEach(System.out::println); //打印：1 3 5 8 9

        //从大到小排序
        Stream.of(9,5,8,3,1)
                .sorted((x,y) -> {
                    return y.compareTo(x);
                })
                .forEach(System.out::println); //打印：9 8 5 3 1
    }
}
