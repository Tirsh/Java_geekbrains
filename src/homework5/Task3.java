package homework5;

public class Task3 {
}
class HeapSort{
    public static int[] sort(int[] arr){
        int arrayLength = arr.length - 1;
        for (int i = arrayLength/2-1; i > 0; i --){
            rootSort(arr,i);
        }
        return arr;
    }
    public static void rootSort(int[] arr, int length, int root){
        int left = root * 2 + 1;
        int right = root * 2 + 2;
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
            rootSort(arr, next);
        }
    }
    public static void copyElements(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
