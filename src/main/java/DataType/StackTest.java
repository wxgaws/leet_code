package DataType;

import org.junit.Test;

import java.util.Stack;

public class StackTest {

    @Test
    public void test1() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        System.out.println(stack);

        System.out.println("peek, " + stack.peek() + ", " + stack);

        System.out.println("pop, " + stack.pop() + ", " + stack);

    }
}
