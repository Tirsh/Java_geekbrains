package homework1;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner;
        do {
            scanner = new Scanner(System.in);
            System.out.println("Input integer number N:");
        }
        while (!scanner.hasNextInt());
        int num = scanner.nextInt();
        scanner.close();
        System.out.printf("Triangular number of N = %d\n",triangularNum(num));
        System.out.printf("Factorial of N = %d\n", fact(num));
    }
    public static int triangularNum(int n){
        if (n == 0) return 0;
        return n + triangularNum(n-1);
    }
    public static int fact(int n){
        if (n == 1) return 1;
        return n * fact(n-1);
    }
}
