package main.java.leetcode;

import java.util.*;

class LRUCache2 {
    //self defined linkedlist
    int capacity;
    Map<Integer, Node> map = new HashMap<>();
    Node head, tail;

    class Node {
        int k;
        int v;
        Node pre;
        Node next;

        Node(int k, int v) {
            this.k = k;
            this.v = v;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        head.next = tail;
        head.pre = tail;
        tail.next = head;
        tail.pre = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        //move to head
        Node cur = map.get(key);
        toHead(cur);

        return cur.v;
    }

    public void put(int key, int value) {
        //exist
        if (map.containsKey(key)) {
            Node cur = map.get(key);
            cur.v = value;
            toHead(cur);
            map.put(key, cur);

        } else {//no
            //full
            if (map.size() == capacity) {
                map.remove(tail.pre.k);
                remove(tail.pre);
            }

            //add
            Node cur = new Node(key, value);
            addHead(cur);
            map.put(key, cur);

        }


    }


    public void remove(Node cur) {
        Node p = cur.pre;
        Node n = cur.next;
        p.next = n;
        n.pre = p;
    }

    public void addHead(Node cur) {
        Node n = head.next;
        n.pre = cur;
        cur.next = n;
        cur.pre = head;
        head.next = cur;
    }

    public void toHead(Node cur) {
        remove(cur);
        addHead(cur);
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */