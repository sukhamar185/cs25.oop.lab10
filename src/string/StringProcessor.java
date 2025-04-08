package string;
import java.util.*;
import java.util.function.*;

public class StringProcessor {

    public static void processStrings(List<String> strings,
                                      Predicate<String> filter,
                                      Function<String, String> transformer,
                                      Consumer<String> printer) {
        for (String s : strings) {
            if (filter.test(s)) {
                String result = transformer.apply(s);
                printer.accept(result);
            }
        }
    }

    public static void main(String[] args) {
        List<String> words = Arrays.asList("Java", "Програмчлал", "Код");

        Predicate<String> filter = s -> s.length() > 5;

        Function<String, String> transformer = s -> new StringBuilder(s).reverse().toString();

        Consumer<String> printer = s -> System.out.println("Garshil: " + s.toUpperCase());

        processStrings(words, filter, transformer, printer);
    }
}
