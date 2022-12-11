package com.leetcode.problems;

import java.util.HashMap;
import java.util.Map;

class Pair {
  String source, target;

  public Pair(String s, String t) {
    this.source = s;
    this.target = t;
  }
}

public class findAndReplaceString_833 {

  public static void main(String[] args) {
    findAndReplaceString_833 far = new findAndReplaceString_833();
    String s = "abcd";
    int[] indices = new int[] { 0, 2 };
    String[] source = new String[] { "a", "cd" };
    String[] target = new String[] { "eee", "ffff" };
    System.out.print(far.findReplaceString(s, indices, source, target));
  }

  public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
    Map<Integer, Pair> hm = new HashMap<>();

    for (int i = 0; i < indices.length; i++) {
      String source = sources[i];
      int index = indices[i];
      String target = targets[i];

      if (index > s.length() || index + source.length() > s.length()) {
        continue;
      } else
        hm.put(index, new Pair(source, target));
    }
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < s.length();) {
      if (hm.containsKey(i)) {
        Pair rep = hm.get(i);
        String source = rep.source;
        String val = rep.target;
        if (s.substring(i, i + source.length()).equals(source)) {
          sb.append(val);
          i = i + source.length();
        }
      } else {
        sb.append(s.charAt(i));
        i++;
      }
    }
    return sb.toString();
  }
}
