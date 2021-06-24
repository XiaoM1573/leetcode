package code;

import java.util.PriorityQueue;

public class PriorityQueueTest {

    public static void main(String[] args) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        minHeap.add(1);
        minHeap.add(2);
        minHeap.add(3);
        System.out.println(minHeap.poll());
        System.out.println(minHeap.poll());
        System.out.println(minHeap.poll());


        maxHeap.add(1);
        maxHeap.add(2);
        maxHeap.add(3);

        System.out.println(maxHeap.poll());
        System.out.println(maxHeap.poll());
        System.out.println(maxHeap.poll());


    }
}
