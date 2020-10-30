package main.java.DataType;

import java.util.*;

public class StringTest {

    public static void test1() {
        String s;
        s = ")";
        System.out.println("s=" + s);
        System.out.println(s == ")");
        System.out.println(s.equals(")"));

        s = ")(".substring(0, 1);
        System.out.println("s=" + s);
        System.out.println(s == ")");
        System.out.println(s.equals(")"));
    }

    public static void main(String[] args) {
        test1();

    }

}
