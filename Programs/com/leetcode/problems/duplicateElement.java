package com.leetcode.problems;

import java.util.Set;
import java.util.HashSet;

public class duplicateElement {
  public static void main(String[] args) {
    duplicateElement de = new duplicateElement();
    System.out.println(de.containsDuplicate(new int[] { 1, 2, 3, }));
  }

  public boolean containsDuplicate(int[] nums) {
    Set<Integer> hs = new HashSet<>();
    for (int i : nums) {
      if (!hs.add(i)) {
        return false;
      }
    }
    return true;
  }
}
