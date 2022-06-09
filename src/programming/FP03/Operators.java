package programming.FP03;

import java.util.List;
import java.util.Random;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Operators {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(2, 4, 6, 5, 7, 11, 12);

        BinaryOperator<Integer> sum1 = Integer::sum;

        //Example of how Binary Operator Works
        BinaryOperator<Integer> sum2 = new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer x, Integer y) {
                return x + y;
            }
        };

        int sum = numbers.stream().reduce(0, sum2);
        System.out.println("Sum " + sum);

        //No input > Rutern Something
        Supplier<Integer> randomIntegerSupplier = () -> {
            Random random = new Random();
            return random.nextInt(1000);
        };

        System.out.println(randomIntegerSupplier.get());

        //Takes one parameter and returns with the calculation you want
        UnaryOperator<Integer> integerUnaryOperator = (x) -> 3 * x;

        System.out.println(integerUnaryOperator.apply(3));
    }
}
