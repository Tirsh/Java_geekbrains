package homework6.options;

import java.util.Scanner;

public class GetRam implements Options{
    Scanner scanner;
    @Override
    public Object getOption() {
        scanner = new Scanner(System.in);
        int value = 0;
        System.out.println("Введите минимальное колличетво ОЗУ:");
        if (scanner.hasNextInt())
            value = scanner.nextInt();
        return value;
    }
}
