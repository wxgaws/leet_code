package leetcode;

import java.util.*;

public class S346_1 {
    class MovingAverage {
        //使用队列，队列的最大长为size
        Deque<Integer> que = new LinkedList<>();
        double sum = 0;//当前求和
        int size = 0;//最大容量，超过时去掉队头元素
        int count = 0;//输入的数据个数

        /**
         * Initialize your data structure here.
         */
        public MovingAverage(int size) {
            this.size = size;
        }

        public double next(int val) {
            que.add(val);
            count++;
            int head = count > size ? que.poll() : 0;
            sum = sum - head + val;
            return sum / Math.min(count, size);
        }
    }

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
}
