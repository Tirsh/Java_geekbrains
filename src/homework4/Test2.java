package homework4;

import java.util.LinkedList;
import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        MyQueueFromLL myQueueFromLL = new MyQueueFromLL(List.of(3,4,6,7,1,2,3,90));
        System.out.println("Create MyQueue from List: " + myQueueFromLL);
        System.out.println("Adding element in the end");
        myQueueFromLL.enqueue(1000);
        System.out.println("MyQueue after adding: " + myQueueFromLL);
        System.out.println("Take first without removing: " + myQueueFromLL.first());
        System.out.println("Take first with removing: " + myQueueFromLL.dequeue());
        System.out.println("MyQueue after actions: " + myQueueFromLL);
        System.out.println();
        System.out.println("Create new empty queue");
        MyQueueFromLL mQ = new MyQueueFromLL<>();
        System.out.println("Adding two elements in the end");
        mQ.enqueue("First");
        mQ.enqueue("Second");
        System.out.println("MyQueue after adding: " + mQ);
        System.out.println("Take first with removing: " + mQ.dequeue());
        System.out.println("MyQueue after actions: " + mQ);
    }
}
class MyQueueFromLL <T> {
    private LinkedList<T> data;

    public MyQueueFromLL() {
        this.data = new LinkedList<>();
    }

    public MyQueueFromLL(List<T> data) {
        this.data = new LinkedList<>(data);
    }
    public void enqueue(T element){
        data.addLast(element);
    }
    public T dequeue(){
        return data.pollFirst();
    }
    public T first(){
        return data.getFirst();
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
