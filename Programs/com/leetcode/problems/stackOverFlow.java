package com.leetcode.problems;

public class stackOverFlow {
  int count = 0;

  public static void main(String[] args) {
    stackOverFlow so = new stackOverFlow();
    so.recur();
  }

  public void recur() {
    System.out.println(count++);
    recur();
  }
}
