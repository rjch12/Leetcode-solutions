package com.leetcode.problems;

public class reorderPowerOf2_869 {
  public static void main(String[] args) {
    reorderPowerOf2_869 rop = new reorderPowerOf2_869();
    System.out.println(rop.reorderedPowerOf2(679213508));
  }

  public boolean reorderedPowerOf2(int n) {

    if (n == 1 || n == 2)
      return true;

    int[] numFreq = getFreq(n);
    for (int i = 2; i < Math.pow(10, 9);) {
      int iFreq[] = getFreq(i);
      if (equal(iFreq, numFreq))
        return true;
      i *= 2;
    }
    return false;
  }

  public boolean equal(int[] a, int[] b) {
    for (int i = 0; i < 10; i++) {
      if (a[i] == b[i]) {
        continue;
      } else
        return false;
    }
    return true;
  }

  public int[] getFreq(int temp) {
    int[] numFreq = new int[10];
    while (temp > 0) {
      numFreq[temp % 10]++;
      temp = temp / 10;
    }
    return numFreq;
  }
}
