package ss11_Stack_Queue.bai_tap.trien_khai_Queue;

public class Test {
    public static void main(String[] args) {

        MyQueue<Integer> myLinkedListQueue= new MyQueue<>();
        myLinkedListQueue.enQueue(2);
        myLinkedListQueue.enQueue(3);
        myLinkedListQueue.enQueue(5);

        myLinkedListQueue.deQueue();
        myLinkedListQueue.displayQueue();
    }
}


