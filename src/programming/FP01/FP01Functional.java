package programming.FP01;

import java.util.List;

public class FP01Functional {


    public static void main(String[] args) {
        List<Integer> integers = List.of(12, 132, 32, 33, 22, 2, 40);
//        printAllNumbersInListStructured(integers);
//        printAllEvenNumbersInListStructured(integers);

        printSquaresOflEvenNumbersInList(integers);
    }

    private static void printAllNumbersInListStructured(List<Integer> numbers) {
        //How to loop
        numbers.forEach(System.out::println); //Method Reference ::
    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }

    private static void printAllEvenNumbersInListStructured(List<Integer> numbers) {
        //How to loop
        numbers.stream().
                filter(FP01Functional::isEven). // Filter - Only Allow Even Numbers
                forEach(System.out::println); //Method Reference ::
    }

    private static void printAllEvenNumbersInListWithLamda(List<Integer> numbers) {
        //How to loop
        numbers.stream().
                filter(number -> number % 2 == 0). // Filter - Only Allow Even Numbers
                forEach(System.out::println); //Method Reference ::
    }

    private static void printSquaresOflEvenNumbersInList(List<Integer> numbers) {
        //How to loop
        numbers.stream().
                filter(number -> number % 2 == 0) // Filter - Only Allow Even Numbers
                .map(number -> number * number)//map
                .forEach(System.out::println); //Method Reference ::
    }

}
