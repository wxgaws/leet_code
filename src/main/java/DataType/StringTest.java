package DataType;

import org.junit.Test;

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

    @Test
    public void test2() {
        Character c = 'A';
        String s = c.toString();
        System.out.println(c);
        System.out.println(s);

    }

    @Test
    public void test3() {
        String s = "abcd";
        System.out.println(s.substring(0,4));
    }

    @Test
    public void test4() {
        StringBuilder sb = new StringBuilder();
        System.out.println(sb.toString().isEmpty());
        System.out.println(sb.toString().equals(""));
        System.out.println("".length());
    }

    public static void main(String[] args) {
        test1();

    }

}
