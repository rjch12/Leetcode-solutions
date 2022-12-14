package com.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class groupAnagrams_49 {
  public static void main(String[] args) {
    groupAnagrams_49 ga = new groupAnagrams_49();
    List<List<String>> res = ga.groupAnagrams(new String[] { "eat", "tea", "tan", "ate", "nat", "bat" });
    for (List<String> s : res) {
      System.out.println(s);
    }
  }

  public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> hm = new HashMap<>();

    // s: tea
    // hm: aet: <eat>
    // key: aet
    // al: <eat, tea>
    for (String s : strs) {
      char[] ch = s.toCharArray();
      Arrays.sort(ch);
      String key = ch.toString();

      List<String> al;

      if (hm.containsKey(key)) {
        al = hm.get(key);
        al.add(s);
        hm.put(key, al);
      } else {
        al = new ArrayList<>();
        al.add(s);
        hm.put(key, al);
      }
    }

    List<List<String>> res = new ArrayList<>();
    for (String key : hm.keySet()) {
      res.add(hm.get(key));
    }
    return res;
  }
}
