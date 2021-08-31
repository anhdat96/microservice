package in28minutes.streamApi;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;


public class BehaviorParameterization {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(12,3,4,5,3,4,522,440);
        List<String> str = Arrays.asList("hello","hi","spring","spring mvc","spring boot");
        int[] arr = {1,2,3,4,5};
        Arrays.stream(arr).min();
        filterAndPrintf(str,numbers, x -> x% 2==0);

        /**
         * Suppose you have a method that takes as its parameter a collection of things,
         * but you want it to be more flexible than just accepting a Collection<Thing>.
         *
         * Case 1: You want to go through the collection and do things with each item.
         * Then the list is a producer, so you should use a Collection < ? extends Thing>.
         *
         * Case 2: You want to add things to the collection.
         * Then the list is a consumer, so you should use a Collection< ? super Thing>.
         */


    }


    private static void filterAndPrintf(List<String> str,List<Integer> numbers, Predicate<? super Integer> predicate){
        numbers.stream()
                .filter(predicate)
                .forEach(System.out::println);
        System.out.println("============================");
        List<String> result = str.stream().map(str1 -> str1+"1").collect(Collectors.toList());
        System.out.println(str);
    }


    Supplier<Integer> randomIntegerSupplier = () -> 2; // () mean no parameter only return 2;
    Supplier<Integer> randomMultipleLineOfCode = () -> {
        return 2;
    };
}
