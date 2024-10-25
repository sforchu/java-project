import java.util.LinkedList;
import java.util.Queue;

public class ExerQueue {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(12);
        queue.offer(2);
        queue.offer(42);
        queue.offer(56);

        queue.peek();
        queue.poll();


        System.out.println(queue);

    }
}
