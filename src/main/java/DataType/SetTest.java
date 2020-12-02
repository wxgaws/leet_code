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

    @Test
    public void test3() {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(4, 5, 6));
        System.out.println("set1:" + set1 + ", " + set1.hashCode() + ", " + System.identityHashCode(set1));
        System.out.println("set2:" + set2 + ", " + set2.hashCode() + ", " + System.identityHashCode(set2));
        set2.clear();
        set2.addAll(set1);
        set1.add(4);
        System.out.println("set1:" + set1 + ", " + System.identityHashCode(set1));
        System.out.println("set2:" + set2 + ", " + System.identityHashCode(set2));
    }

    public static void main(String[] args) {


    }

}
