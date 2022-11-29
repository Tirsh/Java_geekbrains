package homework3;

import java.util.Arrays;
import java.util.List;

public class Task2 {
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(1,3,4,5,6,7,8);
        System.out.println(delEvenFormList(arr));

    }
    public static List<Integer> delEvenFormList(List<Integer> listArray){
        return listArray.stream().filter(a-> a%2 != 0).toList();
    }
}
