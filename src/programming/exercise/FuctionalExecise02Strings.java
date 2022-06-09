package programming.exercise;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FuctionalExecise02Strings {
    public static void main(String[] args) {
        List<String> list = List.of("Spring","Spring" , "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker","Kubernetes");
        printAllCourses(list);
        printTheWordSpring(list);
        printWordsWithMoreThan4Chars(list);
        printTheNumberOfTheCharacters(list);
        normalSortingWithConparator(list);
        normalSorting(list);
        distinct(list);
        reverseSorting(list);
        customSorting(list);
        System.out.println(lengthOfCourses(list));

    }

    private static void printTheNumberOfTheCharacters(List<String> list) {
        System.out.println("Print length of the string");
        list.stream().map(s -> s+" "+ s.length()).forEach(System.out ::println);
        System.out.println("//////////////////////////////////////////");
    }

    private static void printWordsWithMoreThan4Chars(List<String> list) {
        System.out.println("Print words with more than 4 chars");
        list.stream().filter(s -> s.length() >= 4).forEach(System.out::println);
    }

    private static void printTheWordSpring(List<String> list) {
        System.out.println("Print the word Spring");
        list.stream().filter(s -> s.equals("Spring")).forEach(System.out :: println);
        System.out.println("///////////////");
    }

    private static void printAllCourses(List<String> list) {
        System.out.println("Print The List");
        list.stream().forEach(System.out :: println);
        System.out.println("///////////////////////");
    }

    private static void normalSortingWithConparator(List<String> list){
        System.out.println("Sorting with comparator");
        list.stream().sorted(Comparator.naturalOrder()).forEach(System.out::println);
        System.out.println("////////////");
    }

    private static void normalSorting(List<String> list){
        System.out.println("Sorting");
        list.stream().sorted().forEach(System.out::println);
        System.out.println("////////");
    }

    private static void customSorting(List<String> list){
        System.out.println("Sorting by the length");
        list.stream().sorted(Comparator.comparing(String::length)).forEach(System.out::println);
        System.out.println("////////");
    }

    private static void reverseSorting(List<String> list){
        System.out.println("Sorting");
        list.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
        System.out.println("////////");
    }

    private static void distinct(List<String> list){
        System.out.println("Distinct");
        list.stream().distinct().forEach(System.out::println);
        System.out.println("////////");
    }


    private static List<Integer> lengthOfCourses(List<String> list){
        System.out.println("Create a list with length of all Courses");
       return list.stream().map(String::length).collect(Collectors.toList());
    }

}
