import java.util.*;

class MedianFinder {

    private PriorityQueue<Integer> minStack;//存右半部分

    private PriorityQueue<Integer> maxStack;//存左半部分

    public MedianFinder() {
        minStack = new PriorityQueue<>();
        maxStack = new PriorityQueue<>(((o1, o2) -> Integer.compare(o2, o1)));
    }

    public void addNum(int num) {
        if (maxStack.isEmpty() || num <= maxStack.peek()) maxStack.add(num);
        else minStack.add(num);
        while (minStack.size() > maxStack.size()) {
            maxStack.add(minStack.poll());
        }
        while (maxStack.size() > minStack.size()+1) {
            minStack.add(maxStack.poll());
        }
    }

    public double findMedian() {
        if (maxStack.size() != minStack.size()) return (double) maxStack.peek();
        else return ((double) maxStack.peek() + (double) minStack.peek()) / 2;
    }
}

public class Solution {

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        double median;
        median = medianFinder.findMedian();
        System.out.println(median);
        medianFinder.addNum(3);
        median = medianFinder.findMedian();
        System.out.println(median);
    }
}