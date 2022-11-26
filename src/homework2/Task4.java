package homework2;

import homework2.operations.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Task4 {
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

        int action;
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
        SimpleCalc simpleCalc;
        try {
            simpleCalc = new SimpleCalc();
            System.out.printf("Result : %.2f", simpleCalc.calculate(num1, num2, action));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
class SimpleCalc {
    private final Logger logger;
    private final Map<Integer, Operation> operationMap;
    public SimpleCalc() throws IOException {
        logger = Logger.getLogger(SimpleCalc.class.getName());
        FileHandler fh = new FileHandler("./src/homework2/calcLog.txt");
        SimpleFormatter sFormat = new SimpleFormatter();
        logger.addHandler(fh);
        fh.setFormatter(sFormat);
        operationMap = new HashMap<>();
        operationMap.put(1, new Sum());
        operationMap.put(2, new Difference());
        operationMap.put(3, new Multiplication());
        operationMap.put(4, new Division());
    }
    public float calculate(float firstNumber, float secondNumber, int action){
        logger.log(Level.INFO, String.format("Action %d, with %.2f, %.2f", action, firstNumber, secondNumber));
        Operation operation = operationMap.get(action);
        float result = operation.execute(firstNumber, secondNumber);
        logger.log(Level.INFO, String.format("Calculation result %.2f", result));
        return operation.execute(firstNumber, secondNumber);
    }
}
