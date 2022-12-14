package com.leetcode.problems;

import java.util.Map;
import java.util.HashMap;

public class longestSubstringWithoutRepeatingChar_3 {

  public static void main(String[] args) {
    longestSubstringWithoutRepeatingChar_3 lsrc = new longestSubstringWithoutRepeatingChar_3();

    System.out.println(lsrc.lengthOfLongestSubstring("abba"));
  }

  public int lengthOfLongestSubstring(String s) {
    int i = 0, j = 0, maxLen = 0;
    Map<Character, Integer> hm = new HashMap<>();
    for (; j < s.length(); j++) {
      char ch = s.charAt(j);
      if (hm.containsKey(ch)) {
        i = Math.max(hm.get(ch), j);
      }
      hm.put(ch, j);
      maxLen = Math.max(maxLen, (j - i + 1));
    }
    return maxLen;

  }
}
