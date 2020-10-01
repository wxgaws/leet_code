package main.java.leetcode;

public class S346_2 {
    class MovingAverage {
        //使用循环数组实现
        int size;
        int sum;
        int[] arr;
        int count = 0;
        int head = -1;


        /**
         * Initialize your data structure here.
         */
        public MovingAverage(int size) {
            this.size = size;
            this.arr = new int[size];
        }

        public double next(int val) {
            count++;
            int tailVal = count > size ? arr[(head + 1) % size] : 0;//tail元素先保存，否则会被新的head覆盖
            sum = sum - tailVal + val;
            head = (head + 1) % size;
            arr[head] = val;
            return sum * 1.0 / Math.min(count, size);

        }
    }

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
}
