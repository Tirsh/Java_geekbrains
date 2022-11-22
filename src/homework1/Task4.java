package homework1;

import java.util.Arrays;
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input equation (q + w = e, where q, w, e >= 0):");
        String equation = scanner.nextLine();
        String result = testEquation(equation);
        if (result.length() > 0 ) System.out.println(result);
        else System.out.println("No answer!");
    }
    public static boolean equalityCheck(String equality){
        int[] arr = Arrays.stream(equality.replaceAll(" ", "").
                split("[\\+=]")).mapToInt(i->Integer.parseInt(i)).
                toArray();
        return arr[2] == (arr[1] + arr[0]);
    }
    public static String testEquation(String equation){
        for (int i = 0; i < 10; i++)
            for (int j = 0; j < 10; j++) {
                String eq = equation.replaceFirst("\\?", Integer.toString(i))
                        .replaceFirst("\\?", Integer.toString(j));
                if (equalityCheck(eq)) return eq;
            }
        return "";
    }
}
