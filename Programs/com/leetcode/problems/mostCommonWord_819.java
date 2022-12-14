package com.leetcode.problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class mostCommonWord_819 {
  public static void main(String[] args) {
    mostCommonWord_819 mcw = new mostCommonWord_819();

    // System.out.println(mcw.mostCommonWord("Bob hit a ball, the hit BALL flew far
    // after it was hit.", new String[] { "hit" }));
    System.out.println(mcw.mostCommonWord("a, a, a, a, b,b,b,c, c", new String[] { "a" }));
  }

  public String mostCommonWord(String paragraph, String[] banned) {
    Map<String, Integer> hm = new HashMap<>();
    paragraph = paragraph.toLowerCase();
    paragraph = getFixedString(paragraph);

    String[] p = paragraph.split(" ");
    Set<String> hs = new HashSet<>();

    for (String s : banned) {
      s = s.toLowerCase();
      s = getFixedString(s);
      hs.add(s);
    }
    for (String word : p) {
      if (!hs.contains(word))
        hm.put(word, hm.getOrDefault(word, 0) + 1);
    }

    int max = 0;
    String res = "";

    for (String key : hm.keySet()) {
      int freq = hm.get(key);
      if (freq > max) {
        max = freq;
        res = key;
      }
    }
    return res;
  }

  public String getFixedString(String s) {
    s = s.replace(".", "");
    s = s.replace(",", "");
    s = s.replace(";", "");
    s = s.replace("''", "");
    s = s.replace("?", "");
    s = s.replace("!", "");
    return s;
  }
}
