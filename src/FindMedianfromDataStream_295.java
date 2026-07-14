package src;

import java.util.PriorityQueue;

public class FindMedianfromDataStream_295 {
    static class MedianFinder {
        private PriorityQueue<Integer> min;
        private int minL;
        private PriorityQueue<Integer> max;
        private int maxL;
        public MedianFinder() {
            this.min = new PriorityQueue<>();
            this.minL = 0;
            this.max = new PriorityQueue<>((a,b) ->(b - a));
            this.maxL = 0;
        }
        public void addNum(int num) {
            if(max.size() > min.size()){
                max.add(num);
                min.add(max.poll());
            }else{
                min.add(num);
                max.add(min.poll());
            }
        }
        public double findMedian() {
            if((max.size() + min.size()) % 2 == 0){
                return (max.peek() + min.peek()) / 2.0;
            }
            return max.peek();
        }
    }
    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();
        mf.addNum(1);
        mf.addNum(2);
        System.out.println(mf.findMedian());
        mf.addNum(3);
        System.out.println(mf.findMedian());
    }


}
