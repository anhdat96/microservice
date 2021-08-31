package in28minutes.streamApi;

import java.security.PrivilegedAction;
import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterface {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(12,3,4,5,3,4,522,440);

        PrivilegedAction<Function<Integer, Integer>> functionPrivilegedAction = () -> number -> number * number;

        // behind a lambda expression is actually a functional interface ( have only one abstract method )

        Supplier<Predicate<Integer>> predicateSupplier = () -> number -> number % 2 == 0;

        numbers.stream()
                .filter(predicateSupplier.get())
                .map(functionPrivilegedAction.run()) // map from n to -->n *n
                .forEach(System.out::println);

        System.out.println("================================");

        Supplier<BinaryOperator<Integer>> binaryOperatorSupplier = () -> Integer::sum;

        numbers.stream().reduce(binaryOperatorSupplier.get());
    }
}
