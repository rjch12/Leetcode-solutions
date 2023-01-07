/*
 * Question:
 * Design a hit counter which counts the number of hits received in the past 5 minutes.
 * Each function accepts a timestamp parameter (in seconds granularity) and you may assume 
 * that calls are being made to the system in chronological order (ie, the timestamp is monotonically 
 * increasing). You may assume that the earliest timestamp starts at 1.
 * 
 * It is possible that several hits arrive roughly at the same time.
 * 
 * Example:
 * HitCounter counter = new HitCounter();
 * // hit at timestamp 1.
 * System.out.println(counter.hit(1);
 * // hit at timestamp 2.
 * System.out.println(counter.hit(2);
 * // hit at timestamp 3.
 * System.out.println(counter.hit(3);
 * // get hits at timestamp 4, should return 3.
 * System.out.println(counter.getHits(4);
 * // hit at timestamp 300.
 * System.out.println(counter.hit(300);
 * // get hits at timestamp 300, should return 4.
 * System.out.println(counter.getHits(300);
 * // get hits at timestamp 301, should return 3.
 * System.out.println(counter.getHits(301); 
 * 
 * Follow up:
 * What if the number of hits per second could be very large? Does your design scale?
*/

package com.leetcode.problems;

public class DesignHitcounter_362 {
  int[] timeline = new int[300];

  public static void main(String[] args) {
    DesignHitcounter_362 counter = new DesignHitcounter_362();
    // hit at timestamp 1.
    counter.hit(1);
    // hit at timestamp 2.
    counter.hit(2);
    // hit at timestamp 3.
    counter.hit(3);
    // get hits at timestamp 4, should return 3.
    System.out.println(counter.getHits(4));
    // hit at timestamp 300.
    counter.hit(300);
    // get hits at timestamp 300, should return 4.
    System.out.println(counter.getHits(300));
    // get hits at timestamp 301, should return 3.
    System.out.println(counter.getHits(301));
  }

  // index : 1, 2, 3, 4, 5, 6, 7, 8, 9, ...., 299, 301, 302, 303, 305, 305,
  // timeline: 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, ..., 300

  // getHits(4) = 1, 2, 3, 4, ..., 300
  // getHits(304) = 5, 6, 7, 8

  public int getHits(int time) {
    int res = 0;
    if (time > 300) {
      for (int i = 0; i < time % 300; i++)
        timeline[i] = 0;
    }
    for (int i = 0; i < 300; i++)
      res += timeline[i];
    return res;
  }

  public void hit(int time) {
    time = time % 300;
    timeline[time]++;
  }
}
