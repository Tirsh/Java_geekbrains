package homework4;

import java.util.LinkedList;
import java.util.List;

public class Task1 {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList1 = new LinkedList<>(List.of(3,4,6,7,1,2,3,90));
        LinkedList<String> linkedList2 = new LinkedList<>(List.of("abc", "def", "ghi", "jkl"));
        System.out.println("Rotation of " + linkedList1.toString() + " : " + rotateLinkedList(linkedList1));
        System.out.println("Rotation of " + linkedList2.toString() + " : " + rotateLinkedList(linkedList2));
    }
    public static <T> List<T> rotateLinkedList(LinkedList<T> list){
        LinkedList<T> result = new LinkedList<>();
        T element;
        while ((element = list.pollLast()) != null) result.add(element);
        return result;
    }
}
