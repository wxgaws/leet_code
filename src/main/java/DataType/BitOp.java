package DataType;

import java.util.*;

/**
 * 位运算
 */
public class BitOp {

    public BitOp() {
    }

    public static void swap(int a, int b) {
        System.out.printf("a=%d, b=%d\n", a, b);
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.printf("a=%d, b=%d\n", a, b);

    }

    public static void main(String[] args) {
        System.out.println("BitOp");

        swap(3, -107);

    }

}
