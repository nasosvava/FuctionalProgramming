package programming.exercise;

import java.util.List;
import java.util.stream.Collectors;

public class Fuctional03Numbers {
    public static void main(String[] args) {
        List<Integer> integers = List.of(20,21 ,22 ,25);

        System.out.println(sumSquare(integers));
        System.out.println("//////////////");
        System.out.println(sumCubes(integers));
        System.out.println("//////////////");
        System.out.println(sumOdd(integers));
        System.out.println("//////////////");
        System.out.println(squareThisList(integers));
        System.out.println("//////////////");
        System.out.println(returnOnlyTheEven(integers));
    }

    private static int sumSquare(List<Integer> integers) {
        System.out.println("Square every number in a list and find the sum of squares");
        return integers.stream().map(number -> number * number).reduce(0, Integer::sum);
    }

    private static int sumCubes(List<Integer> integers) {
        System.out.println("Cube every number in a list and find the sum of cube");
        return integers.stream().map(number -> number * number *number).reduce(0, Integer::sum);
    }

    private static int sumOdd(List<Integer> integers) {
        System.out.println("Find sum of odd numbers in the list");
        return integers.stream().filter(number -> number%2 !=0).reduce(0, Integer::sum);
    }

    private static List<Integer> squareThisList(List<Integer> list) {
        System.out.println("Square the list");
        return list.stream().map(number -> number * number).collect(Collectors.toList());
    }

    private static List<Integer>  returnOnlyTheEven(List<Integer> list) {
        System.out.println("Return only the even");
        return list.stream().filter(number -> number%2 == 0).collect(Collectors.toList());
    }

}
