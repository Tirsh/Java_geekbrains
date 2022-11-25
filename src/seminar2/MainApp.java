package seminar2;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input string:");
        String s = scanner.nextLine();
//        System.out.println(coding(s));
        System.out.println(test(s));
    }
    public static String coding(String str){
        int counter = 1;
        StringBuilder stringBuilder = new StringBuilder();
        char ch = str.charAt(0);
        for (int i = 1; i < str.length(); i++){
            if (str.charAt(i) == ch){
                counter++;
            }
            else{
                stringBuilder.append(ch);
                stringBuilder.append(counter);
                counter = 1;
                ch = str.charAt(i);
            }
        }
        stringBuilder.append(ch);
        stringBuilder.append(counter);
        return stringBuilder.toString();
    }
    public static boolean test(String str){
        int len = str.length();
        StringBuilder half = new StringBuilder(str.substring(len/2));
        half.reverse();
        if (str.substring(0,len/2+1).equals(half.toString()))
            return true;
        else
            return false;
    }
}
