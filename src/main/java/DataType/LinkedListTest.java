package DataType;

import org.junit.Test;

import java.util.*;

public class LinkedListTest {
    @Test
    public void test1() {
        LinkedList<Integer> deque = new LinkedList<>();
        deque.push(1);
        deque.push(2);
        System.out.println("LinkedList push: " + deque);

        deque.clear();
        deque.addLast(1);
        deque.addLast(2);
        System.out.println("LinkedList addLast: " + deque);

        deque.clear();
        deque.addFirst(1);
        deque.addFirst(2);
        System.out.println("LinkedList addFirst: " + deque);

        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        System.out.println("stack push: " + stack);

        stack.clear();
        stack.add(1);
        stack.add(2);
        System.out.println("stack add: " + stack);

    }

    public static void main(String args[]) {
        //remove(obj)和remove(index)
        //要调用remove(obj)需要强制转化remove((Type) obj)
        LinkedList<Integer> list = new LinkedList<>();
        list.add(10);
        list.add(20);
        System.out.println("list=" + list);
        list.remove((Integer) 10);
        System.out.println("list=" + list);
        list.remove(1);
        System.out.println("list=" + list);

    }
}
