import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SortEvenNumbers {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String> input = Arrays.stream(scanner.nextLine()
                        .split(", "))
                .collect(Collectors.toList());

        List<Integer> numbers = input.stream()
                .map(Integer::parseInt).collect(Collectors.toList());

        Predicate<Integer> filterEvenNumber = e -> e % 2 == 0;

        List<Integer> evenNumbers = numbers
                .stream()
                .filter(filterEvenNumber)
                .collect(Collectors.toList());

        Function<Stream<Integer>,String> mutator = x -> x.map(String::valueOf)
                .collect(Collectors.joining(", "));


        String result = mutator.apply(evenNumbers.stream());

        String sortedResult = mutator.apply(evenNumbers.stream().sorted());

        System.out.println(result);
        System.out.println(sortedResult);
    }
}
