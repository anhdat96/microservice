package in28minutes.streamApi;


import java.util.Arrays;
import java.util.List;

public class FP01Functional {
    public static void main(String[] args) {
        printfAllNumberInList(Arrays.asList(12,3,4,5,3,3,32));
    }

    private static void printfNumber(int number){
        System.out.println(number);
    }
    private static boolean isEvent(int number ){
        return number%2==0;
    }

    private static void printfAllNumberInList(List<Integer> numbers) {
        numbers.stream()
                .filter(FP01Functional::isEvent)  // only number satisfied this will printf
                .forEach(FP01Functional::printfNumber);
        System.out.println("================================");

        numbers.stream()
                .filter(number -> number%2==0)
                .map(number -> number *number) // map from n to -->n *n
                .forEach(System.out::println);




        // method reference (className::methodName)
    }
    // lambda expression is help you to create simpler method
}
