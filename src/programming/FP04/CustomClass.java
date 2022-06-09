package programming.FP04;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CustomClass {
    public static void main(String[] args) {
        List<Course> courses = List.of(
                new Course("Spring", "Framework", 98, 20000),
                new Course("Spring Boot", "Framework", 95, 18000), new Course("API", "Microservices", 97, 22000),
                new Course("Microservices", "Microservices", 96, 25000),
                new Course("FullStack", "FullStack", 91, 14000), new Course("AWS", "Cloud", 92, 21000),
                new Course("Azure", "Cloud", 99, 21000), new Course("Docker", "Cloud", 92, 20000),
                new Course("Kubernetes", "Cloud", 91, 20000));

        // allMatch, noneMatch, anyMatch
        Predicate<Course> reviewScoreGreaterThan95Predicate
                = course -> course.getReviewScore() > 95;

        Predicate<Course> reviewScoreGreaterThan90Predicate
                = course -> course.getReviewScore() > 90;

        Predicate<Course> reviewScoreLessThan90Predicate
                = course -> course.getReviewScore() < 90;
        //allMatch
        System.out.println(courses.stream().allMatch(reviewScoreGreaterThan95Predicate));
        //noneMatch
        System.out.println(courses.stream().noneMatch(reviewScoreLessThan90Predicate));
        //anyMatch
        System.out.println(courses.stream().anyMatch(reviewScoreLessThan90Predicate));
        //anyMatch
        System.out.println(courses.stream().anyMatch(reviewScoreGreaterThan95Predicate));

        Comparator<Course> comparingByNoOfStudentsIncreasing = Comparator.comparingInt(Course::getNoOfStudents);

        System.out.println(courses.stream().sorted(comparingByNoOfStudentsIncreasing).collect(Collectors.toList()));

        Comparator<Course> comparingByNoOfStudentsDecreasing = Comparator.comparingInt(Course::getNoOfStudents).reversed();

        System.out.println(courses.stream().sorted(comparingByNoOfStudentsDecreasing).collect(Collectors.toList()));

        //Compare using the number of student and after the review score
        Comparator<Course> comparingByNoOfStudentsAndNoOfReviews = Comparator.comparingInt(Course::getNoOfStudents).thenComparingInt(Course::getReviewScore).reversed();

        System.out.println(courses.stream().sorted(comparingByNoOfStudentsAndNoOfReviews).collect(Collectors.toList()));
        //limit
        System.out.println(courses.stream().sorted(comparingByNoOfStudentsAndNoOfReviews).limit(1).collect(Collectors.toList()));
        //skip
        System.out.println(courses.stream().sorted(comparingByNoOfStudentsAndNoOfReviews).skip(7).collect(Collectors.toList()));
        //skip and limit
        System.out.println(courses.stream().sorted(comparingByNoOfStudentsAndNoOfReviews).skip(3).limit(2).collect(Collectors.toList()));
        //takeWhile
        System.out.println(courses.stream().takeWhile(c -> c.getReviewScore() >= 95).collect(Collectors.toList()));
        //dropWhile
        System.out.println(courses.stream().dropWhile(c -> c.getReviewScore() >= 95).collect(Collectors.toList()));
        //max it returns the last element of the list
        System.out.println(courses.stream().max(comparingByNoOfStudentsAndNoOfReviews));
        //min it returns the first element of the list
        System.out.println(courses.stream().min(comparingByNoOfStudentsAndNoOfReviews));
        //min with filter Optional or Else
        System.out.println(courses.stream().filter(course -> course.getName().equals("aaaaaaa")).max(comparingByNoOfStudentsAndNoOfReviews).orElse(new Course("Kubernetes", "Cloud", 91, 20000)));
        //Find first
        System.out.println(courses.stream().filter(reviewScoreGreaterThan95Predicate).findFirst().orElse(null));
        //find any
        System.out.println(courses.stream().filter(reviewScoreGreaterThan95Predicate).findAny().orElse(null));
        //map and mapToInt
        //mapToInt ->Primitive
        System.out.println(courses.stream().filter(reviewScoreGreaterThan95Predicate).mapToInt(Course::getNoOfStudents).sum());
        //average
        System.out.println(courses.stream().filter(reviewScoreGreaterThan95Predicate).mapToInt(Course::getNoOfStudents).average());
        //count
        System.out.println(courses.stream().filter(reviewScoreGreaterThan95Predicate).mapToInt(Course::getNoOfStudents).count());
        //max -> maximum value of a student of a course with filter reviewScoreGreaterThan95Predicate
        System.out.println(courses.stream().filter(reviewScoreGreaterThan95Predicate).mapToInt(Course::getNoOfStudents).max());
        //min -> minimum value of a student of a course with filter reviewScoreGreaterThan95Predicate
        System.out.println(courses.stream().filter(reviewScoreGreaterThan95Predicate).mapToInt(Course::getNoOfStudents).max());
        //group courses by the category
        System.out.println(courses.stream().collect(Collectors.groupingBy(Course::getCategory)));
        //group courses counting category courses
        System.out.println(courses.stream().collect(Collectors.groupingBy(Course::getCategory, Collectors.counting())));
        //group courses highest review score
        System.out.println(courses.stream().collect(Collectors.groupingBy(Course::getCategory, Collectors.maxBy(Comparator.comparing(Course::getReviewScore)))));
        //group courses compare the course reviewScore
        System.out.println(courses.stream().collect(Collectors.groupingBy(Course::getCategory, Collectors.mapping(Course::getName, Collectors.toList()))));


        Predicate<Course> reviewScoreGreaterThan95Predicate2 = createPredicateWithCutoffReviewScore(95);

        Predicate<Course> reviewScoreGreaterThan90Predicate2 = createPredicateWithCutoffReviewScore(90);
    }

    private static Predicate<Course> createPredicateWithCutoffReviewScore(int cutoffReviewScore) {
        return course -> course.getReviewScore() > cutoffReviewScore;
    }
}

