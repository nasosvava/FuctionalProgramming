package programming.FP03;

import org.w3c.dom.ls.LSOutput;

import java.util.List;
import java.util.Random;
import java.util.function.*;

public class LambdasBehindTheScenes {
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        List<Integer> numbers = List.of(2, 4, 6, 5, 7, 11, 12);

        Predicate<Integer> integerPredicate = x -> x % 2 == 0;
        //Example of how predicate works returns boolean
        Predicate<Integer> integerPredicate1 = new Predicate<Integer>() {
            @Override
            public boolean test(Integer x) {
                return x%2==0;
            }
        };

        Function<Integer, Integer> integerIntegerFunction = x -> x * x;
        //Example of how function works
        Function<Integer, Integer> integerIntegerFunction1 = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer x) {
                return x * x;
            }
        };

        Consumer<Integer> soutConsumer  = System.out ::println;
        //Example of how Consumer works
        Consumer<Integer> consumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer x) {
                System.out.println(x);
            }
        };

        numbers.stream().filter(integerPredicate1).map(integerIntegerFunction1).forEach(consumer);


        BiPredicate<Integer , String> biPredicate  = (n,s) -> {return n < 10 && s.length() > 5;};
        System.out.println(biPredicate.test(9 ,"testString"));


        BiFunction<Integer,String, String> biFunction = (n ,s) ->{return n+s;};
        System.out.println(biFunction.apply(1,"test"));

        BiConsumer<String ,String> biConsumer = (str,str1) -> {
            System.out.println(str);
            System.out.println(str1);
        };
        biConsumer.accept("1344", "adsdsad");;
    }
}
