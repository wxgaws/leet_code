package main.java.leetcode;

import java.util.*;

public class prime {

    /**
     * 筛选法, 求不大于N的所有素数
     */
    public static List<Integer> prime1(int N) {
        LinkedList<Integer> listPrime = new LinkedList<>();
        listPrime.add(2);
        LinkedList<Integer> listRaw = new LinkedList<>();
        for (int i = 3; i <= N; i++) {
            listRaw.add(i);
        }

        while (!listRaw.isEmpty()) {
            int maxPrime = listPrime.getLast();
            //delete
            for (Iterator<Integer> iter = listRaw.iterator(); iter.hasNext(); ) {
                if (iter.next() % maxPrime == 0) iter.remove();
            }

            //new prime
            if (!listRaw.isEmpty()) listPrime.add(listRaw.getFirst());
        }

        return new ArrayList<>(listPrime);
    }

    public static boolean isPrime(int N) {
        if (N < 2) return false;
        int R = (int) Math.sqrt(N);
        for (int d = 2; d <= R; ++d) {
            System.out.println("d=" + d);
            if (N % d == 0) return false;
        }

        return true;
    }


    public static void main(String[] args) {
        System.out.println("prime");
//        System.out.println(prime1(100));
        System.out.println(isPrime(5));
    }

}
