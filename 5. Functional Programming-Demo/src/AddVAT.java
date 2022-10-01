import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class AddVAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Double> input = Arrays.stream(scanner.nextLine().split(", "))
                .map(Double::parseDouble)
                .collect(Collectors.toList());

        UnaryOperator<Double> priceWithVAT = x -> x * 1.20;


        System.out.println("Prices with VAT:");
        input.forEach(r -> System.out.printf("%.2f%n",priceWithVAT.apply(r)));
    }
}
