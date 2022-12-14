package com.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class textJustification_68 {
  public List<String> fullJustify(String[] words, int maxWidth) {
    List<String> res = new ArrayList<>();
    int index = 0;
    while (index < words.length) {

      String s = words[index];
      int len = s.length();
      int end = index;

      if (len < maxWidth) {
        end = index + 1;
        while (end < words.length && words[end].length() + len + 1 < maxWidth) {
          len += words[end].length() + 1;
          end++;
        }
        if (end < words.length - 1)
          res.add(midJustified(words, index, end, len, maxWidth));
        else
          res.add(leftJustify(words, index, words.length, len, maxWidth));
      }
      index = end + 1;
    }
    return res;
  }

  public String leftJustify(String[] words, int startIndex, int endIndex, int totalCharlen, int maxWidth) {
    StringBuilder sb = new StringBuilder();
    int totalExtraSpaces = (maxWidth - totalCharlen) / (endIndex - startIndex);

    for (int i = startIndex; i < endIndex; i++) {
      sb.append(words[i]);
      for (int j = 0; j < totalExtraSpaces; j++)
        sb.append(" ");
    }
    return sb.toString();
  }

  public String midJustified(String[] words, int startIndex, int endIndex, int totalCharlen, int maxWidth) {
    StringBuilder sb = new StringBuilder();
    int totalExtraSpaces = maxWidth - totalCharlen;
    int extraLeftPadding = totalExtraSpaces / (endIndex - startIndex);
    int spaceBw = totalExtraSpaces / (endIndex - startIndex);

    sb.append(words[startIndex]);
    while (extraLeftPadding > 0) {
      sb.append(" ");
      extraLeftPadding--;
    }

    for (int i = startIndex + 1; i <= endIndex; i++) {
      sb.append(words[i]);

      for (int j = 0; j < spaceBw; j++)
        sb.append(" ");
    }
    return sb.toString();
  }
}
