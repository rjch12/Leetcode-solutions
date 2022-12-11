package com.leetcode.problems;

import java.util.LinkedList;
import java.util.Queue;

public class hitCounter {
  Queue<Integer> q;

  public static void main(String[] args) {
    hitCounter hc = new hitCounter();
    hc.hit(1);
    hc.hit(2);
    hc.hit(3);
    hc.getHits(4);
    hc.hit(300);
    hc.getHits(300);
    hc.getHits(301);
  }

  public hitCounter() {
    q = new LinkedList<>();
  }

  public void hit(int timestamp) {
    q.add(timestamp);
  }

  public int getHits(int timestamp) {
    while (!this.q.isEmpty()) {
      int diff = timestamp - q.peek();
      if (diff >= 300)
        q.poll();
      else
        break;
    }
    System.out.println(q.size());
    return q.size();
  }

}
