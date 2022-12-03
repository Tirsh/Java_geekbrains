package homework4;

import homework4.operations.*;

import java.io.IOException;
import java.util.*;
import java.util.logging.*;

public class Task3 {
    public static void main(String[] args) throws IOException {
        boolean end;
        int action = 0;
        SimpleCalc simpleCalc = new SimpleCalc();
        Deque<Double> result = new ArrayDeque<>();
        do {
            double num1;
            if (action == 1 || action == 2) {
                num1 = result.size() > 0? result.getLast(): 0;
                System.out.println("Previous number: " + num1);
            }else num1 = inputNumber("Input first number N:");
           double num2 = inputNumber("Input second number N:");

            do {
                action = (int)inputNumber("Input action: 1. Sum; 2. Difference; 3. Multiplication; 4. Division");
            } while (action <= 0 || action >= 5);

            result.addLast(simpleCalc.calculate(num1, num2, action));
            System.out.printf("Result : %.2f\n\n", result.getLast());

            do {
                action = (int)inputNumber("What next?\n1. Continue with result\n2. Drop last result and continue with previous\n3. Calculation with new numbers\n4. Exit\n");
            } while (action <= 0 || action >= 5);
            end = action == 4;
            if (action == 2) result.removeLast();
        }while (!end);
    }
    public static double inputNumber(String message){
        Scanner scanner;
        double result;
        while (true) {
            scanner = new Scanner(System.in);
            scanner.reset();
            System.out.println(message);
            if (scanner.hasNextDouble()) {
                result = scanner.nextDouble();
                break;
            }
        }
        return result;
    }
}
class SimpleCalc {
    private final Logger logger;
    private final Map<Integer, Operation> operationMap;
    private final FileHandler fh;
    public SimpleCalc() throws IOException {
        logger = Logger.getLogger(SimpleCalc.class.getName());
        fh = new FileHandler("./src/homework4/calcLog.txt");
        SimpleFormatter sFormat = new SimpleFormatter();
        logger.addHandler(fh);
        fh.setFormatter(sFormat);
        operationMap = new HashMap<>();
        operationMap.put(1, new Sum());
        operationMap.put(2, new Difference());
        operationMap.put(3, new Multiplication());
        operationMap.put(4, new Division());
    }
    public double calculate(double firstNumber, double secondNumber, int action){
        logger.log(Level.INFO, String.format("Action %d, with %.2f, %.2f", action, firstNumber, secondNumber));
        Operation operation = operationMap.get(action);
        double result = operation.execute(firstNumber, secondNumber);
        logger.log(Level.INFO, String.format("Calculation result %.2f", result));
        return operation.execute(firstNumber, secondNumber);
    }
}
