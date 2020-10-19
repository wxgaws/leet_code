package main.java.leetcode;

import java.util.*;

class LCP18 {
    public int breakfastNumber(int[] staple, int[] drinks, int x) {
        int count = 0;
        List<Integer[]> sList = sort(staple, x, false);
        List<Integer[]> dList = sort(drinks, x, true);

        //i升序遍历sList，j降序遍历dList
        int j = dList.size() - 1;
        for (int i = 0; i < sList.size() && j >= 0; i++) {
            int sCost = sList.get(i)[0];
            int sN = sList.get(i)[1];
            int dLeft = x - sCost;
            if (dLeft < 0) break;//越往后钱越不够
            while (j >= 0 && dLeft < dList.get(j)[0]) {
                j--;
            }
            if (j >= 0) {
                int dN = dList.get(j)[1];
                count += sN * dN;
            }
            // System.out.printf("sCost=%d, sCost=%d, count=%d\n",sCost,dList.get(j)[0], count );
        }

        count = count % 1000000007;
        return count;
    }

    //返回升序List(price,n)，价格不超过price的商品选法数
    public List<Integer[]> sort(int arr[], int cost, Boolean isSum) {
        TreeMap<Integer, Integer> map = new TreeMap();
        List<Integer[]> list = new ArrayList();
        for (int price : arr) {
            if (price < cost) {
                int n = 1 + map.getOrDefault(price, 0);
                map.put(price, n);
            }
        }
        int sum = 0;//价格不超过price的个数和
        for (int key : map.keySet()) {
            int n = map.get(key);
            if (isSum) {
                sum += n;
                list.add(new Integer[]{key, sum});
            } else {
                list.add(new Integer[]{key, n});
            }

        }
        // System.out.println("sort:");
        // for(Integer[] a:list){
        //     System.out.println(a[0]+","+a[1]);
        // }
        return list;
    }
}
