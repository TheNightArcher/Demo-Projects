import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> input = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());

        Function<List<String>, Integer> count = x -> x.stream().mapToInt(Integer::parseInt).sum();

        System.out.printf("Count = %d %n",input.size());
        System.out.printf("Sum = %d",count.apply(input));
    }
}
