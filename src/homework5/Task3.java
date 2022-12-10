package homework5;

import java.util.Arrays;
import java.util.Random;

public class Task3 {
    public static void main(String[] args) {
        Random random = new Random();
        int n = random.nextInt(5,15);
        int[] array = new int[n];
        for (int i = 0; i < n; i++) array[i] = random.nextInt(-100, 100);
        System.out.println("Create random array on integers:");
        System.out.println(Arrays.toString(array));

        System.out.println("Make heap sort:");
        array = HeapSort.sort(array);
        System.out.println(Arrays.toString(array));
    }


}
class HeapSort{
    public static int[] sort(int[] arr){
        int arrayLength = arr.length - 1;
        for (int i = (arrayLength-1)/2; i >= 0; i --){
            rootSort(arr, i, arrayLength);
        }
        for (int i = arrayLength; i > 0; i--){
            copyElements(arr, 0, i);
            rootSort(arr, 0, i-1);
        }
        return arr;
    }
    private static void rootSort(int[] arr, int root, int max){
        if (root == max) return;
        int left = root * 2 + 1;
        int right = (root * 2 + 2)>max? left: root * 2 + 2;
        int next;
        if (arr[root] < arr[left] || arr[root] < arr[right]){
            if (arr[left] < arr[right]) {
                copyElements(arr, root, right);
                next = right;
            }
            else{
                copyElements(arr, root, left);
                next = left;
            }
            if (next <= (max-1)/2)
                rootSort(arr, next, max);
        }
    }
    private static void copyElements(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
