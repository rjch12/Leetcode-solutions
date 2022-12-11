package com.leetcode.problems;

public class randomPickWithWeight_528 {
  int preSum[];
  int totalSum = 0;

  public static void main(String[] args) {
    randomPickWithWeight_528 rpww = new randomPickWithWeight_528(new int[] { 1, 3 });
    System.out.println(rpww.pickIndex());
    System.out.println(rpww.pickIndex());
    System.out.println(rpww.pickIndex());
    System.out.println(rpww.pickIndex());
    System.out.println(rpww.pickIndex());
  }

  public randomPickWithWeight_528(int[] w) {
    preSum = new int[w.length];
    for (int i = 0; i < w.length; i++) {
      totalSum += w[i];
      preSum[i] = totalSum;
    }
  }

  public int pickIndex() {
    double index = 10 * Math.random();
    for (int i = 0; i < preSum.length; i++) {
      if (index < preSum[i]) {
        return i;
      }
    }
    return 0;
  }
}
