import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CountUpperWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> input = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        Predicate<String> filterWords = x -> Character.isUpperCase(x.charAt(0));

        List<String> count = input.stream().filter(filterWords).collect(Collectors.toList());

        System.out.println(count.size());
        input.stream()
                .filter(filterWords)
                .forEach(r -> System.out.printf("%s %n", r));
    }
}
