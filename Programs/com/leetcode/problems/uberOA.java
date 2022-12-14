/*
 * You are given two arrays of integers a and b, and two integers lower and upper.
 * Your task is to find the number of pairs (i, j) such that lower ≤ a[i] * a[i] + b[j] * b[j] ≤ upper.
 * 
 * Example:
 * For a = [3, -1, 9], b = [100, 5, -2], lower = 7, and upper = 99, the output should be boundedSquareSum(a, b, lower, upper) = 4.
 * There are only four pairs that satisfy the requirement:
 * If i = 0 and j = 1, then a[0] = 3, b[1] = 5, and 7 ≤ 3 * 3 + 5 * 5 = 9 + 25 = 36 ≤ 99.
 * If i = 0 and j = 2, then a[0] = 3, b[2] = -2, and 7 ≤ 3 * 3 + (-2) * (-2) = 9 + 4 = 13 ≤ 99.
 * If i = 1 and j = 1, then a[1] = -1, b[1] = 5, and 7 ≤ (-1) * (-1) + 5 * 5 = 1 + 25 = 26 ≤ 99.
 * If i = 2 and j = 2, then a[2] = 9, b[2] = -2, and 7 ≤ 9 * 9 + (-2) * (-2) = 81 + 4 = 85 ≤ 99.
 * For a = [1, 2, 3, -1, -2, -3], b = [10], lower = 0, and upper = 100, the output should be boundedSquareSum(a, b, lower, upper) = 0.
 * Since the array b contains only one element 10 and the array a does not contain 0, it is not possible to satisfy 0 ≤ a[i] * a[i] + 10 * 10 ≤ 100.
 */
package com.leetcode.problems;

import java.util.Arrays;

public class uberOA {

  public static void main(String[] args) {
    uberOA uoa = new uberOA();
    System.out.println(uoa.boundedSquareSum(new int[] { 3, -1, 9 }, new int[] { 100, 5, -2 }, 7, 99));
  }

  int res = 0;

  public int boundedSquareSum(int[] a, int[] b, int lower, int upper) {
    int res = 0;

    if (a.length < b.length) {
      int[] temp = a;
      a = b;
      b = temp;
    }
    Arrays.sort(b);

    for (int i = 0; i < a.length; i++) {
      int aSq = a[i] * a[i];
      binarySearch(lower, upper, aSq, b, 0, b.length - 1);
    }
    return res;

  }

  public void binarySearch(int lowerBound, int upperBound, int aSq, int[] b, int start, int end) {

    while (start <= end) {
      int mid = start + end / 2;
      if (mid < 0 || mid >= b.length)
        return;
      int combinedSum = (b[mid] * b[mid]) + aSq;
      if (combinedSum >= lowerBound && combinedSum <= upperBound) {
        res++;
      }
      if (combinedSum >= upperBound) {
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }
  }
}
