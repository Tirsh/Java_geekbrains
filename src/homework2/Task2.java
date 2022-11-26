package homework2;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.*;

public class Task2 {
    public static void main(String[] args) {
        int[] arr = {5, 10, 2, 18, 6};

        try {
            System.out.println(Arrays.toString(bubbleSort(arr)));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static int[] bubbleSort(int[] array) throws IOException {
        Logger logger = Logger.getLogger(Task2.class.getName());
        FileHandler fh = new FileHandler("./src/homework2/log.txt");
        logger.addHandler(fh);
        SimpleFormatter sFormat = new SimpleFormatter();
        fh.setFormatter(sFormat);
        boolean sorted = false;
        int tmp;
        while (!sorted){
            for (int i = 0; i < array.length-1; i++) {
                sorted = true;
                if (array[i] > array[i+1]){
                    sorted = false;
                    tmp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = tmp;
                }
                logger.log(Level.INFO, Arrays.toString(array));
            }
        }
        return array;
    }
}
