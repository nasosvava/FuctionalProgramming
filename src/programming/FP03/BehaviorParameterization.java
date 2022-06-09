package programming.FP03;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class BehaviorParameterization {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(2, 4, 6, 5, 7, 11, 12);
        filterAndPrint(numbers, x -> x%2 == 0);
        filterAndPrint(numbers, x -> x%2 != 0);
        List<Integer> squaredNumbers = mapAndCreateNewList(numbers, x->x*x);
        List<Integer> cubedNumbers = mapAndCreateNewList(numbers, x->x*x*x);
        List<Integer> doubledNumbers = mapAndCreateNewList(numbers, x->x*2);
    }

    private static void filterAndPrint(List<Integer> numbers, Predicate<? super Integer> predicate) {
        numbers.stream().filter(predicate).forEach(System.out::println);
    }

    private static List<Integer> mapAndCreateNewList(List<Integer> numbers , Function<Integer,Integer> function){
        return numbers.stream().map(function).collect(Collectors.toList());
    }
}
