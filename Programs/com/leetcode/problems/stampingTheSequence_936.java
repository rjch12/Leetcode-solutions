package com.leetcode.problems;

import java.util.*;

public class stampingTheSequence_936 {
  public static void main(String[] args) {
    stampingTheSequence_936 sts = new stampingTheSequence_936();
    for (int i : (sts.movesToStamp("abc", "ababc"))) {
      System.out.print(i + " ");
    }
  }

  public int[] movesToStamp(String stamp, String target) {
    char[] tgt = target.toCharArray();
    char[] st = stamp.toCharArray();
    boolean visited[] = new boolean[tgt.length];
    List<Integer> arr = new ArrayList<>();

    int count = 0;

    while (count != tgt.length) {
      boolean changed = false;

      for (int i = 0; i <= tgt.length - st.length; i++) {
        if (!visited[i] && matchesString(tgt, i, st)) {
          count = updatetgt(tgt, i, st.length, count);
          arr.add(i);
          visited[i] = true;
          changed = true;
        }
        if (count == tgt.length)
          break;
      }
      if (!changed)
        return new int[0];
    }

    int[] res = new int[arr.size()];
    int k = 0;
    for (int i = arr.size() - 1; i >= 0; i--) {
      res[k++] = arr.get(i);
    }
    return res;
  }

  public int updatetgt(char[] tgt, int index, int len, int count) {
    for (int i = 0; i < len; i++) {
      if (tgt[i + index] != '?') {
        tgt[i + index] = '?';
        count++;
      }
    }
    return count;
  }

  public boolean matchesString(char[] tgt, int index, char[] st) {
    for (int i = 0; i < st.length; i++) {
      if (tgt[i + index] != '?' && tgt[i + index] != st[i])
        return false;
    }
    return true;
  }
}
