package homework1;

import java.util.ArrayList;
import java.util.List;

public class
Task2 {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        int N = 1000;
        for (int i = 2; i <= 1000; i++){
            boolean flag = true;
            for (Integer n:numbers){
                if (i % n == 0){
                    flag = false;
                    break;
                }
            }
            if (flag) numbers.add(i);
        }
        System.out.println(numbers);
    }
}
