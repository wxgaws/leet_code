package DataType;

import org.junit.Test;

import java.util.*;

public class QueueTest {
    @Test
    public void test1() {
        //单向队列
        Queue<Integer> que = new LinkedList<>();
        que.offer(3);
        que.offer(1);
        que.offer(4);
        System.out.println("que, " + que);
        System.out.println("peek, " + que.peek() + ", " + que);
        System.out.println("poll, " + que.poll() + ", " + que);
        System.out.println();

        //双向队列
        Deque<Integer> deque = new LinkedList<>();
        deque.offerFirst(3);
        deque.offerFirst(1);
        deque.offerLast(4);
        System.out.println("deque, " + deque);
        System.out.println("peekFirst, " + deque.peekFirst() + ", " + deque);
        System.out.println("pollFirst, " + deque.pollFirst() + ", " + deque);
        System.out.println("peekLast, " + deque.peekLast() + ", " + deque);
        System.out.println("pollLast, " + deque.pollLast() + ", " + deque);


    }
}
