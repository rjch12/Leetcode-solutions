

package com.leetcode.problems;

public class strStr_28 {
  public static void main(String[] args) {
    strStr_28 ss = new strStr_28();
    System.out.println(ss.strStr("a", ""));
  }
  public int strStr(String haystack, String needle) {
    if (needle.length() == 0) 
      return 0;
    
    if (haystack.length() == 0) 
      return -1;
    
    for (int i = 0; i <= haystack.length() - needle.length(); ++i) {
      if (haystack.charAt(i) == needle.charAt(0) && isSame(haystack.substring(i, i + needle.length()), needle)) {
        return i;
      }
    }
    return -1;
  }

  public boolean isSame(String haystack, String needle) {
    int i = 0;
    while (i < needle.length()) {
      if (haystack.charAt(i) != needle.charAt(i))
        return false;
      ++i;
    }
    return true;
  }

}
