package Laba_4;
import java.util.*;
import java.util.stream.Collectors;

public class StreamTasks
{
    public static double getAverage(List<Integer> numbers)
    {
        return numbers.stream().mapToInt(Integer::intValue).average().orElse(0);
    }

    public static List<String> addPrefixAndUpperCase(List<String> strings)
    {
        return strings.stream().map(s -> "_new_" + s.toUpperCase()).collect(Collectors.toList());
    }

    public static List<Integer> getUniqueSquares(List<Integer> numbers)
    {
        return numbers.stream().filter(i -> Collections.frequency(numbers, i) == 1).map(i -> i * i).collect(Collectors.toList());
    }

    public static <T> T getLastElement(Collection<T> collection)
    {
        return collection.stream().reduce((first, second) -> second).orElseThrow(() -> new NoSuchElementException("Collection is empty"));
    }

    public static int sumEvenNumbers(int[] numbers)
    {
        return Arrays.stream(numbers).filter(n -> n % 2 == 0).sum();
    }

    public static Map<Character, String> listToMap(List<String> strings)
    {
        return strings.stream().filter(s -> s != null && !s.isEmpty()).collect(Collectors.toMap(s -> s.charAt(0),s -> s.substring(1), (existing, replacement) -> replacement));
    }
}