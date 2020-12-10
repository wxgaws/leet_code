package DataType;

import java.util.*;

public class ComparatorTest {

    public static void testInterface() {
        int[][] arr = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                //0维降序，1维升序
                int res = (o1[0] == o2[0]) ? (o1[1] - o2[1]) : (o2[0] - o1[0]);
                return res;
            }
        });

        System.out.println("testInterface");
        for (int[] p : arr) System.out.println(Arrays.toString(p));

    }

    public static void testInterface2() {
        int[][] arr = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        Comparator<int[]> comparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                //0维降序，1维升序
                int res = (o1[0] == o2[0]) ? (o1[1] - o2[1]) : (o2[0] - o1[0]);
                return res;
            }
        };
        Arrays.sort(arr, comparator);

        System.out.println("testInterface2");
        for (int[] p : arr) System.out.println(Arrays.toString(p));

    }

    public static void testLambda() {
        int[][] arr = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        Arrays.sort(arr, (o1, o2) -> {
            //0维降序，1维升序
            int res = (o1[0] == o2[0]) ? (o1[1] - o2[1]) : (o2[0] - o1[0]);
            return res;
        });

        System.out.println("testLambda");
        for (int[] p : arr) System.out.println(Arrays.toString(p));
    }

    public static void main(String[] args) {
        testInterface();
        testInterface2();
        testLambda();

    }

}
