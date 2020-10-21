package main.java.DataType;

import java.util.LinkedList;

public class LinkedListTest {
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
