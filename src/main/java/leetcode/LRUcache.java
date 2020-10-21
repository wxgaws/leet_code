package main.java.leetcode;

import java.util.*;

class LRUCache {
    int capacity;//capacity
    HashMap<Integer, Integer> map = new HashMap<>();//map
    LinkedList<List<Integer>> list = new LinkedList<>();//linedlist

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            List<Integer> obj = new ArrayList<Integer>() {
                {
                    add(key);
                    add(map.get(key));
                }
            };
            list.remove(obj);
            list.addFirst(obj);
            // System.out.println(key+",last="+list.getLast().get(0)+", first="+list.getFirst().get(0)+", map="+map);
        }
        // System.out.println(key+", get, list" + list+", map="+map);
        return this.map.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        // System.out.println("before: "+map);
        //  System.out.println(key+","+value);
        //加入头结点
        List<Integer> obj = new ArrayList<Integer>() {
            {
                add(key);
                add(map.getOrDefault(key, -1));
            }
        };
        list.remove(obj);
        obj = new ArrayList<Integer>() {
            {
                add(key);
                add(value);
            }
        };
        list.addFirst(obj);
        map.put(key, value);


        //已满时，删除尾节点
        if (map.size() > this.capacity) {
            map.remove(list.removeLast().get(0));
        }

        // System.out.println("after: "+map);
        // System.out.println(key+","+value+", put, list="+list+", map="+map);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */