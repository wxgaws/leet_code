package DataType;

import org.junit.Test;

import java.util.*;

public class PriorityQueueTest {

    //问题1：默认顺序的队首元素最最大值，还是最小值？
    public static void test1() {
        PriorityQueue<Integer> que = new PriorityQueue<>();
        que.add(1);
        que.add(2);
        System.out.println(que.peek());
    }

    public static void test2() {
        PriorityQueue<String> que = new PriorityQueue<>();
        que.add("A");
        que.add("B");
        System.out.println(que.peek());
    }

    public static void test3() {
        PriorityQueue<Integer> que = new PriorityQueue<>((a1, a2) -> {
//            return a1 - a2;//升序
            return a2 - a1;//降序
        });
        que.add(1);
        que.add(2);
        System.out.println(que.peek());
    }

    @Test
    public void test4() {
        PriorityQueue<Integer> que = new PriorityQueue<>((a1, a2) -> {
            return a2 - a1;
        });
        que.offer(3);
        que.offer(1);
        que.offer(2);
        System.out.println(que);
        System.out.println("peek, " + que.peek() + ", " + que);
        System.out.println("poll, " + que.poll() + ", " + que);
    }

    public static void main(String[] args) {
//        test1();
//        test2();
        test3();

//        System.out.println("1".compareTo("A"));//-16，数字在字面前面
//        System.out.println("A".compareTo("a")); //-32, 大写在小写前面
//        System.out.println("a".compareTo("b")); //-1，a在b前面
//        System.out.println("a".compareTo("a"));//0，相等


    }

}
