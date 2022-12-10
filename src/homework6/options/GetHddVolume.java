package homework6.options;

import java.util.Scanner;

public class GetHddVolume implements Options{
    Scanner scanner;
    @Override
    public Object getOption() {
        scanner = new Scanner(System.in);
        int value = 0;
        System.out.println("Введите минимальный объем HDD:");
        if (scanner.hasNextInt())
            value = scanner.nextInt();
        return value;
    }
}
