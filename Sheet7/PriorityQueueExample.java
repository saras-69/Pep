import java.util.PriorityQueue;

public class PriorityQueueExample {
    public static void main(String[] args) {
        PriorityQueue<Integer> q = new PriorityQueue();
        q.add(5);
        q.add(4);
        q.add(3);
        q.add(2);
        q.add(1);
        q.add(-1);
        System.out.println("Element with max" + q.peek());
        System.out.println(q);
        System.out.println("Delete element" + q.poll());
        System.out.println("Element with max" + q.peek());
        System.out.println(q);

    }

}
