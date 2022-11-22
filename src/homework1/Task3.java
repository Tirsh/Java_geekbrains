package homework1;

import homework1.operations.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner;
        do {
            scanner = new Scanner(System.in);
            System.out.println("Input first number N:");
        }
        while (!scanner.hasNextInt());
        int num1 = scanner.nextInt();
        do {
            scanner = new Scanner(System.in);
            System.out.println("Input second number N:");
        }
        while (!scanner.hasNextInt());
        int num2 = scanner.nextInt();

        int action = 1;
        do {
            scanner = new Scanner(System.in);
            System.out.println("Input action: 1. Sum; 2. Difference; 3. Multiplication; 4. Division");
            if (scanner.hasNextInt()){
                action = scanner.nextInt();
                if (action > 0 && action < 5) break;
            }
        }
        while (true);
        scanner.close();
        SimpleCalc simpleCalc = new SimpleCalc();
        System.out.printf("Result : %.2f", simpleCalc.calculate(num1, num2, action));
    }

}
class SimpleCalc {
    private Map<Integer, Operation> operationMap;
    public SimpleCalc() {
        operationMap = new HashMap<>();
        operationMap.put(1, new Sum());
        operationMap.put(2, new Difference());
        operationMap.put(3, new Multiplication());
        operationMap.put(4, new Division());
    }
    public float calculate(float firstNumber, float secondNumber, int action){
        Operation operation = operationMap.get(action);
        return operation.execute(firstNumber, secondNumber);
    }

}
