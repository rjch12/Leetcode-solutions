import java.util.*;

package com.leetcode.problems;

public class LRU_146 {
  package com.leetcode.problems;

public class node {
    node prev, next;
    int key, val;

    public node(int k, int v) {
      this.key = k;
      this.val = v;
      this.prev = null;
      this.next = null;
    }
  }

  node head, tail;
  Map<Integer, node> hm = new HashMap<>();
  int size = 0, cap = 0;

  public static void main(String[] args) {
    LRU_146 l = new LRU_146(2);
    // ["LRUCache","put","put","get","put","get","put","get","get","get"]
    // [[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]

    l.put(1, 1);
    l.put(2, 2);
    System.out.println(l.get(1));
    l.put(3, 3);
    System.out.println(l.get(2));
    l.put(4, 4);
    System.out.println(l.get(1));
    System.out.println(l.get(3));
    System.out.println(l.get(4));
  }

  public LRU_146(int capacity) {
    head = new node(-1, -1);
    tail = new node(-1, -1);
    head.next = tail;
    tail.prev = head;
    cap = capacity;
  }

  // head - > 1 - > 2 - > tail

  public int get(int key) {
    if (size == 0 || !hm.containsKey(key))
      return -1;

    node temp = hm.get(key);
    removeEle(temp);
    addToFirst(temp);
    return temp.val;
  }

  public void put(int key, int value) {
    node p;
    if (hm.containsKey(key)) {
      p = hm.get(key);
      removeEle(p);
    }
    p = new node(key, value);
    addToFirst(p);
    size++;
    hm.put(key, p);
    if (size > cap) {
      hm.remove(tail.prev.key);
      removeEle(tail.prev);
      size--;
    }

  }

  // head -> last -> tail

  public void removeEle(node temp) {
    temp.prev.next = temp.next;
    temp.next.prev = temp.prev;
  }

  // head -> 1 -> tail
  public void addToFirst(node temp) {
    temp.next = head.next;
    head.next.prev = temp;
    temp.prev = head;
    head.next = temp;
  }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */