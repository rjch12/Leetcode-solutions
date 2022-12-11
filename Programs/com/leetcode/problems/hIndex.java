package com.leetcode.problems;

public class hIndex {
  public static void main(String[] args) {
    hIndex hi = new hIndex();
    System.out.println(hi.hIndexx(new int[] { 3, 0, 6, 5, 1 }));
  }

  public int hIndexx(int[] citations) {
    int n = citations.length;
    int[] buckets = new int[n + 1];
    for (int c : citations) {
      if (c >= n) {
        buckets[n]++;
      } else {
        buckets[c]++;
      }
    }
    int count = 0;
    for (int i = n; i >= 0; i--) {
      count += buckets[i];
      if (count >= i) {
        return i;
      }
    }
    return 0;
  }
}
