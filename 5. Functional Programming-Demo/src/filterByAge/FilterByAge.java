package filterByAge;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilterByAge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int peoplesCount = Integer.parseInt(scanner.nextLine());

        List<Person> peoples = new ArrayList<>();

        while (peoplesCount != 0) {
            Object[] peoplesData = Arrays.stream(scanner.nextLine().split(", ")).toArray();

            String name = peoplesData[0].toString();
            Integer age = Integer.valueOf(peoplesData[1].toString());

            Person person = new Person(name, age);

            peoples.add(person);

            peoplesCount--;
        }

        String condition = scanner.nextLine();

        int age = Integer.parseInt(scanner.nextLine());

        List<String> outputStyle = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());


        Predicate<Person> getFilter = filterByAge(condition, age);

        Stream<Person> passedPeoples = peoples.stream()
                .filter(getFilter);

        printByOutputStyle(outputStyle, passedPeoples);
    }

    private static void printByOutputStyle(List<String> outputStyle, Stream<Person> passedPeoples) {
        if (outputStyle.size() == 2) {
            passedPeoples.forEach(p -> System.out.printf("%s - %d %n", p.getName(), p.getAge()));
        } else if (outputStyle.get(0).equals("name")) {
            passedPeoples.forEach(p -> System.out.println(p.getName()));
        } else {
            passedPeoples.forEach(p -> System.out.println(p.getAge()));
        }
    }

    private static Predicate<Person> filterByAge(String condition, int age) {
        return condition.equals("older")
                ? p -> p.getAge() >= age
                : p -> p.getAge() <= age;
    }
}
