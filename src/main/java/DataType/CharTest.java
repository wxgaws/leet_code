package DataType;

import java.util.*;

public class CharTest {

    public static void test1() {
        char c;
        c = '(';
        System.out.println(c == '(');
        //char是基本数据类型，没有equals()
//        System.out.println(c.equals('c'));
    }

    public static void main(String[] args) {
        test1();
    }

}
