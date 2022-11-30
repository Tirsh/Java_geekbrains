package homework3;

import java.util.Arrays;
import java.util.List;

public class Task3 {
    public static void main(String[] args) {
        List<Integer> arrayList = Arrays.asList(1, 4, -3, 8, 10, 88,-6, 0);
        System.out.printf("Minimum value: %d\n", arrayList.stream().min(Integer::compare).get());
        System.out.printf("Maximum value: %d\n", arrayList.stream().max(Integer::compare).get());
        System.out.printf("Average value: %.2f", arrayList.stream().mapToDouble(i -> i).average().getAsDouble());
    }
}
