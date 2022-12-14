package com.leetcode.problems;

public class addBinary_67 {
  public static void main(String[] args) {
    addBinary_67 ab = new addBinary_67();
    System.out.println(ab.addBinary("1010", "1011"));
  }

  public String addBinary(String a, String b) {
    StringBuilder res = new StringBuilder();

    char[] ac = a.toCharArray();
    char[] bc = b.toCharArray();
    int blen = bc.length - 1;
    int alen = ac.length - 1;
    int carry = 0, sum = 0;
    while (alen > 0 && blen > 0) {
      sum = carry + (ac[alen] - '0') + (bc[blen] - '0');
      carry = 0;
      if (sum > 1) {
        carry = 1;
        res.append(sum == 2 ? '0' : '1');
      } else
        res.append('0');
      alen--;
      blen--;
    }
    while (alen > 0) {
      sum = carry + (ac[alen] - '0');
      carry = 0;
      if (sum > 1) {
        carry = 1;
        res.append(sum == 2 ? '0' : '1');
      } else
        res.append('0');
      alen--;
    }
    while (blen > 0) {
      sum = carry + (bc[blen] - '0');
      carry = 0;
      if (sum > 1) {
        carry = 1;
        res.append(sum == 2 ? '0' : '1');
      } else
        res.append('0');
      blen--;
    }
    return res.toString();
  }
}
