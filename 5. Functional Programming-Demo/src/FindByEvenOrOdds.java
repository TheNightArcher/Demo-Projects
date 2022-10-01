import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindByEvenOrOdds {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] range = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        String condition = scanner.nextLine();

        filterNumbersByCondition(range[0], range[1],
                condition.equals("even")
                        ? n -> n % 2 == 0
                        : n -> n % 2 != 0);
    }

    private static void filterNumbersByCondition(int start, int end, Predicate<Integer> condition) {
        System.out.print(IntStream.rangeClosed(start, end)
                .boxed()
                .filter(condition)
                .map(String::valueOf)
                .collect(Collectors.joining(" ")));
    }
}
