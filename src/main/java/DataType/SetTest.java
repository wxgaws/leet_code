package main.java.DataType;

import org.junit.Test;

import java.util.*;

public class SetTest {

    public SetTest() {
    }

    @Test
    public void test1() {
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

    @Test
    public void test2() {
        Set<List<Integer>> set = new HashSet<>();
        set.add(new ArrayList<>(Arrays.asList(1, 2, 3)));
        set.add(new ArrayList<>(Arrays.asList(1, 2, 3)));
        System.out.println(set);
    }

    public static void main(String[] args) {


    }

}
