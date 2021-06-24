package code;

import java.util.PriorityQueue;

public class Solution295 {

    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();
        mf.addNum(1);
        System.out.println(mf.findMedian());
        mf.addNum(3);
        System.out.println(mf.findMedian());
    }

}

class MedianFinder {

    // 大顶堆，用于存储较小的一半
    public PriorityQueue<Integer> maxHeap;
    // 小顶堆，用于存储较大的一半
    public PriorityQueue<Integer> minHeap;

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        minHeap.add(num);
        maxHeap.add(minHeap.poll());
        if (maxHeap.size() > minHeap.size()) {
            minHeap.add(maxHeap.poll());
        }
    }

    public double findMedian() {
        int sum = maxHeap.size() + minHeap.size();
        System.out.println(sum);
        if (sum % 2 == 0) {
            //偶数
            return (double) (maxHeap.peek() + minHeap.peek()) / 2;
        } else {

            return (double) minHeap.peek();
        }
    }

}