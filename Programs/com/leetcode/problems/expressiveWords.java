package com.leetcode.problems;

import java.util.List;
import java.util.ArrayList;

public class expressiveWords {

  public class pair {
    char ch;
    int freq;

    public pair(char s, int freq) {
      this.ch = s;
      this.freq = freq;
    }
  }

  public static void main(String[] args) {
    expressiveWords ew = new expressiveWords();
    // String words[] = { "hello", "hi", "helo" };
    String words[] = { "zzyy", "zy", "zyy" };

    // System.out.println(ew.expressiveWord("heeellooo", words));
    System.out.println(ew.expressiveWord("zzzzzyyyyy", words));
  }

  public int expressiveWord(String s, String[] words) {

    List<pair> sList = getFreqCount(s);
    int count = 0;

    List<List<pair>> wList = new ArrayList<List<pair>>();
    for (String w : words) {
      wList.add(getFreqCount(w));
    }

    for (List<pair> wWord : wList) {

      if (isExpressive(sList, wWord))
        count++;
    }

    return count;
  }

  public boolean isExpressive(List<pair> sWord, List<pair> wWord) {

    if (sWord.size() != wWord.size())
      return false;

    int i = sWord.size() - 1;

    while (i >= 0) {

      if (wWord.get(i).ch != sWord.get(i).ch)
        return false;

      if (wWord.get(i).freq != sWord.get(i).freq) {
        if (wWord.get(i).freq > sWord.get(i).freq || sWord.get(i).freq < 3) {
          return false;
        }
      }
      i--;
    }

    return true;
  }

  public List<pair> getFreqCount(String s) {

    List<pair> res = new ArrayList<>();

    if (s.length() == 1) {
      res.add(new pair(s.charAt(0), 1));
    }

    else {
      int startInd = 0, endInd = 1;
      while (endInd < s.length()) {
        if (s.charAt(startInd) != s.charAt(endInd)) {
          res.add(new pair(s.charAt(startInd), (endInd - startInd)));
          startInd = endInd;
        }
        endInd++;
      }
      if (startInd != endInd)
        res.add(new pair(s.charAt(startInd), (endInd - startInd)));
    }
    return res;
  }
}