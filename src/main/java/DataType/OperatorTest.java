package main.java.DataType;

import java.util.*;

public class OperatorTest {

    public static void test1() {
        int max = 0;
        System.out.println(max);
        boolean res = (max-- == 0);
        System.out.println(res);
        System.out.println(max);
    }

    public static void main(String[] args) {
        test1();
    }

}
