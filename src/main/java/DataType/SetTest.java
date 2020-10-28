package main.java.DataType;

import java.util.*;

public class SetTest {

    public SetTest() {
    }

    public static void main(String[] args) {
        Set<List<Integer>> set1 = new HashSet<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        set1.add(list1);

        System.out.println("#1, set1=" + set1);

        System.out.println("list1 hashcode=" + list1.hashCode());
        list1.add(2);
        System.out.println("list1 exist=" + set1.contains(list1));
        set1.add(list1);
        System.out.println("list1 hashcode=" + list1.hashCode());

        System.out.println("#2, set1=" + set1);

    }

}
