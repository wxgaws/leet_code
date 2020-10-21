package main.java.leetcode;

import java.util.*;

class LRUCache {
    //map+linkedlist
    int capacity;
    Map<Integer, Integer> map;//map(key, value)
    LinkedList<Integer> list;//linkedlist(key)

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.list = new LinkedList<>();
    }

    public int get(int key) {
        //to head
        if (list.contains(key)) {
            list.remove((Integer) key);
            list.addFirst(key);
        }
        return map.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        //add head
        if (list.contains(key)) {
            list.remove((Integer) key);
        }
        list.addFirst(key);
        map.put(key, value);

        //full, remove tail
        if (list.size() > capacity) {
            int keyLast = list.removeLast();
            map.remove(keyLast);
        }

    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */