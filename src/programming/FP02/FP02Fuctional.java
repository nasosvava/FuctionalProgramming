package programming.FP02;

import java.util.List;

public class FP02Fuctional {
    public static void main(String[] args) {
        List<Integer> integers = List.of(12, 132, 32, 33, 22, 2, 40);

        int sum = addListFructionalWithLambda(integers);
        System.out.println("sum : " + sum);

        int sumLamda = addListFructionalWithLambda(integers);
        System.out.println("sumLamda : " + sumLamda);

        int sumReference = addListFunctionalReference(integers);
        System.out.println("sumReference :" + sumReference);
    }

    private static int sum(int aggregate, int nextNumber) {
        return aggregate + nextNumber;
    }

    private static int addListFructional(List<Integer> integers) {
        //Stream of number -> One result value
        //Combine them into one result => One value
        // 0 and FP02Functional::sum
        return integers.stream()
                .reduce(0, FP02Fuctional::sum);
    }

    private static int addListFructionalWithLambda(List<Integer> integers) {
        //Stream of number -> One result value
        //Combine them into one result => One value
        // 0 and FP02Functional::sum
        return integers.stream()
                .reduce(0, (x, y) -> x + y);
    }

    private static int addListFunctionalReference(List<Integer> integers) {
        //Stream of number -> One result value
        //Combine them into one result => One value
        // 0 and FP02Functional::sum
        return integers.stream()
                .reduce(0, Integer::sum);
    }
}
