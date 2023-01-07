// Question:
// Design a hit counter which counts the number of hits received : the past 5 minutes.

// Each function accepts a timestamp parameter (in seconds granularity) and you may assume that calls are being made to the system : chronological order (ie, the timestamp is monotonically increasing). You may assume that the earliest timestamp starts at 1.

// It is possible that several hits arrive roughly at the same time.

// Example:

// HitCounter2 counter = new HitCounter2();

// // hit at timestamp 1.
// counter.hit(1);

// // hit at timestamp 2.
// counter.hit(2);

// // hit at timestamp 3.
// counter.hit(3);

// // get hits at timestamp 4, should return 3.
// counter.getHits(4);

// // hit at timestamp 300.
// counter.hit(300);

// // get hits at timestamp 300, should return 4.
// counter.getHits(300);

// // get hits at timestamp 301, should return 3.
// counter.getHits(301); 
// Follow up:
// What if the number of hits per second could be very large? Does your design scale?

// Website:https://repl.it/languages/csharp
package com.leetcode.problems;

public class HitCounter2 {
  int[] hits;

  public static void main(String[] args) {
    HitCounter2 hc = new HitCounter2();
    hc.Hit(1);
    hc.Hit(2);
    hc.Hit(3);
    System.out.println(hc.GetHits(4));
    hc.Hit(300);
    System.out.println(hc.GetHits(300));
    System.out.println(hc.GetHits(301));
  }

  public HitCounter2() {
    hits = new int[301];
  }

  public void Hit(int seconds) {
    if (seconds > 300)
      for (int i = 1; i <= seconds % 300; i++)
        hits[i] = 0;
    hits[seconds % 300] = 1;
  }

  public int GetHits(int seconds) {
    int sum = 0;
    for (int i = 1; i < 301; i++)
      sum += hits[i];
    return sum;
  }
}
