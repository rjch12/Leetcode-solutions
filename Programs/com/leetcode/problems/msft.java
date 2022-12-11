// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");
package com.leetcode.problems;

import java.util.*;

public class msft {
  public static void main(String otfs[]) {
    msft s = new msft();
    System.out.println(s.find(new String[] { "039", "4", "14", "32", "", "34", "7" }));
  }

  public int find(String[] E) {
    // write your code in Java SE 8
    int res = 0, index = 0;
    HashMap<Character, Integer> hm = new HashMap<>();
    for (String s : E) {
      for (int i = 0; i < s.length(); i++) {
        hm.put(s.charAt(i), index);
      }
      index++;
    }
    System.out.println(hm);

    return res;
  }
}
