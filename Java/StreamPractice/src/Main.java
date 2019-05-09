import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String>myList = Arrays.asList("cat","apple","dog","car","question","application","app");
        myList
                .stream()
                .filter(s -> s.startsWith("c"))
                .forEach(System.out::println); //lehetett meg .collect(Collectors.toList());
        myList
                .stream()
                .filter(s -> s.contains("pp") && s.length() > 3)
                .forEach(System.out::println);
        myList
                .stream()
                .sorted()
                .limit(3) //.subList(0,3) csak collect utan hasznalhato, listara!!!
                .forEach(System.out::println);
    }
}