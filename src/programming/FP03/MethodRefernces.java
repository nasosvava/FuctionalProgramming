package programming.FP03;

import java.util.List;
import java.util.function.Supplier;

public class MethodRefernces {
    public static void main(String[] args) {
        List<String> courses = List.of("Spring","Spring" , "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker","Kubernetes");

        courses.stream().map(String::length).forEach(System.out::println);

        Supplier<String> supplier = String::new; // Create new Object
    }
}
