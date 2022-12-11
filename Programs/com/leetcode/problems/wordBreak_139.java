/*
 * Medium
 * Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.
 * Note that the same word in the dictionary may be reused multiple times in the segmentation.
 * Example 1:
 * Input: s = "leetcode", wordDict = ["leet","code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 */

import java.util.*;

package com.leetcode.problems;

public class wordBreak_139 {
  public static void main(String[] args) {
    wordBreak_139 wb = new wordBreak_139();
    // System.out.println(wb.wordBreak("leetcode", new
    System.out.println(wb.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",new ArrayList<String>(Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"))));
    // System.out.println(wb.wordBreak("leetcode",new ArrayList<String>(Arrays.asList("leet", "code"))));
    // System.out.println(wb.wordBreak("aaaaaaa", new ArrayList<String>(Arrays.asList("aaaa", "aaa"))));
  }

  // public boolean wordBreak(String s, List<String> wordDict) {
  // int[] mem = new int[s.length()];
  // Arrays.fill(mem, -1);
  // return checkWords(s.toCharArray(), 0, wordDict, mem);
  // }

  // public boolean checkWords(char[] s, int offsetIndex, List<String> wordDict,
  // int[] mem) {
  // if (offsetIndex == s.length)
  // return true;

  // if (mem[offsetIndex] != -1)
  // return mem[offsetIndex] == 0 ? false : true;

  // String temp = "";
  // for (int i = offsetIndex; i < s.length; i++) {
  // temp += s[i];
  // if (wordDict.contains(temp) && checkWords(s, i + 1, wordDict, mem)) {
  // mem[i] = 1;
  // return true;
  // }
  // }
  // mem[offsetIndex] = 0;
  // return false;
  // }
  // }

  public boolean wordBreak(String s, List<String> wordDict) {
    int[] arr = new int[s.length()];
    Arrays.fill(arr, -1);
    Set<String> hs = new HashSet<>();
    for (String w : wordDict)
      hs.add(w);
    return checkWord(s.toCharArray(), 0, hs, arr);
  }

  public boolean checkWord(char[] arr, int index, Set<String> wordDict, int[] mem) {
    if (index >= arr.length)
      return true;

    if (mem[index] != -1)
      return mem[index] == 1 ? true : false;

    String text = "";
    for (int i = index; i < arr.length; i++) {
      text += arr[i];
      if (wordDict.contains(text) && checkWord(arr, i + 1, wordDict, mem)) {
        mem[i] = 1;
        return true;
      }
    }
    mem[index] = 0;
    return false;
  }
}