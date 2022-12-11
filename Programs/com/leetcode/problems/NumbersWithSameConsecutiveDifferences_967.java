package com.leetcode.problems;

import java.util.*;

public class NumbersWithSameConsecutiveDifferences_967 {
  public static void main(String[] args) {
    NumbersWithSameConsecutiveDifferences_967 n = new NumbersWithSameConsecutiveDifferences_967();
    for (int i : n.numsSameConsecDiff(3, 7))
      System.out.println(i);
  }

  public int[] numsSameConsecDiff(int n, int k) {
    Set<Integer> al = new HashSet<>();

    if (n == 1)
      al.add(0);
    else {
      for (int i = 1; i <= 9; i++) {
        getNums(i, n - 1, k, al);
      }
    }
    int arr[] = new int[al.size()];
    int index = 0;
    for (int i : al)
      arr[index++] = i;

    return arr;
  }

  public void getNums(int start, int n, int k, Set<Integer> al) {
    if (n == 0) {
      al.add(start);
      return;
    }

    int lastDigit = start % 10;
    if (lastDigit >= k)
      getNums(start * 10 + lastDigit - k, n - 1, k, al);
    if (lastDigit + k <= 9)
      getNums(start * 10 + lastDigit + k, n - 1, k, al);
  }
}
