package homework6.options;

import java.util.Scanner;

public class GetOs implements Options{
    Scanner scanner;
    @Override
    public Object getOption() {
        scanner = new Scanner(System.in);
        String value = "";
        System.out.println("Введите операционную систему:");
        if (scanner.hasNextLine())
            value = scanner.nextLine();
        return value;
    }
}
