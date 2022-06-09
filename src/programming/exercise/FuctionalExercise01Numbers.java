package programming.exercise;

import java.util.List;

public class FuctionalExercise01Numbers {

    public static void main(String[] args) {
        List<Integer> integers = List.of(20,21 ,22 ,25);
     printOnlyTheOdd(integers);

     printCubes(integers);
    }

    private static void printCubes(List<Integer> integers) {
        System.out.println("Print the cubes");
        integers.stream().map(number-> number * number * number).forEach(System.out ::println);
        System.out.println("////////////////////////////");
    }

    private static void printOnlyTheOdd(List<Integer> integers) {
        System.out.println("Print The Odd numbers");
        integers.stream().filter(number -> number%2 !=0).forEach(System.out :: println);
    }


}
