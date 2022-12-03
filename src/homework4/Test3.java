package homework4;
import homework2.operations.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Test3 {
    public static void main(String[] args) {
        CalcFrame calcFrame = new CalcFrame();
    }
}

class CalcFrame {
    private JFrame window;
    private JButton buttonEquals;
    private JButton buttonPlus;
    private JButton buttonMinus;
    private JButton buttonMulti;
    private JButton buttonDivide;
    private JTextField textField1;
    private JTextField textField2;


    public CalcFrame() {
        window = new JFrame("Calculator");
        buttonEquals = new JButton("=");
        buttonPlus = new JButton("+");
        buttonMinus = new JButton("-");
        buttonDivide = new JButton("/");
        buttonMulti = new JButton("*");
        textField1 = new JTextField();
        textField2 = new JTextField();

        textField1.setBounds(40, 10, 310, 50);
        textField2.setBounds(40, 80, 310, 50);
        buttonEquals.setBounds(300,80,45,25);
        buttonPlus.setBounds(10,80,45,25);
        buttonMinus.setBounds(65,80,45,25);
        buttonMulti.setBounds(120,80,45,25);
        buttonDivide.setBounds(175,80,45,25);
        window.add(textField1);
        window.add(textField2);
        window.add(buttonEquals);
        window.add(buttonPlus);
        window.add(buttonMinus);
        window.add(buttonMulti);
        window.add(buttonDivide);
        window.setSize(380,150);
        window.setLayout(null);
        window.setVisible(true);


    }
}
class SimpleCalc {
    private final Logger logger;
    private final Map<Integer, Operation> operationMap;
    public SimpleCalc() throws IOException {
        logger = Logger.getLogger(homework4.SimpleCalc.class.getName());
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



