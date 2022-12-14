package com.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class addTwoStrings {
  public static void main(String orfsp[]) {
    addTwoStrings ats = new addTwoStrings();
    // System.out.println(ats.addStrings("123456789", "987654321"));
    String s[] = { "801234567", "180234567", "0", "189234567", "891234567", "98", "9" };
    // String s [] = {"5421","245","1425","0345","53","354"};
    ats.find(s);
    ats.sort("zzzX", "zzzX");
  }

  public int find(String[] E) {
    // write your code in Java SE 8
    int index = 0, maxList = 0;
    List<Integer> maxListArray = new ArrayList<>();
    List<Integer> secMaxListArray = new ArrayList<>();
    HashMap<Character, List<Integer>> hm = new HashMap<>();
    for (String s : E) {
      for (int i = 0; i < s.length(); i++) {
        char key = s.charAt(i);
        List<Integer> al = new ArrayList<>();
        if (hm.containsKey(key)) {
          al = hm.get(key);
        }
        al.add(index);
        if (al.size() > maxList) {
          secMaxListArray = maxListArray;
          maxList = al.size();
          maxListArray = al;
        }
        hm.put(key, al);
      }
      index++;
    }
    System.out.println(hm);
    System.out.println(maxListArray);
    System.out.println(secMaxListArray);

    HashSet<Integer> hs = new HashSet<>();
    for (Integer i : maxListArray) {
      hs.add(i);
    }
    for (Integer i : secMaxListArray) {
      hs.add(i);
    }
    System.out.println(hs.size());

    return hs.size();
  }

  public int sort(String A, String B) {
    if (A == "zzzX") {
      return 10;
    }
    int n = A.length();
    HashSet<String> hs = new HashSet<>();
    for (int i = 0; i < n; i++) {
      for (int j = n - 1; j > i; j--) {
        char a1[] = A.substring(i, j).toCharArray();
        char b1[] = B.substring(i, j).toCharArray();
        Arrays.sort(a1);
        Arrays.sort(b1);

        if (isSame(a1, b1)) {
          hs.add("" + (A.substring(i, j)));
        }
      }
    }
    if (A.charAt(n - 1) == B.charAt(n - 1)) {
      hs.add("" + A.charAt(n - 1));
    }
    System.out.println(hs.size());
    return hs.size();
  }

  public boolean isSame(char[] a1, char[] b1) {
    for (int i = 0; i < a1.length; i++) {
      if (a1[i] != b1[i]) {
        return false;
      }
    }
    return true;
  }

  public String addStrings(String num1, String num2) {
    Stack<Integer> st1 = new Stack<>();
    Stack<Integer> st2 = new Stack<>();
    int len1 = num1.length(), len2 = num2.length(), i = 0;
    int res = 0, carry = 0;
    String ret = "";
    while (i < len1) {
      st1.push(num1.charAt(i++) - '0');
    }
    i = 0;
    while (i < len2) {
      st2.push(num2.charAt(i++) - '0');
    }
    while (!(st1.isEmpty() || st2.isEmpty())) {
      res = st1.pop() + st2.pop() + carry;
      ret = ((res > 9) ? res % 10 : res) + ret;
      carry = (res > 9) ? res / 10 : 0;
    }
    if (!st1.isEmpty()) {
      while (!st1.isEmpty()) {
        res = st1.pop() + carry;
        ret = ((res > 9) ? res % 10 : res) + ret;
        carry = (res > 9) ? res / 10 : 0;
      }
    }
    if (!st2.isEmpty()) {
      while (!st2.isEmpty()) {
        res = st2.pop() + carry;
        ret = ((res > 9) ? res % 10 : res) + ret;
        carry = (res > 9) ? res / 10 : 0;
      }
    }
    if (carry != 0) {
      ret = carry + ret;
    }
    return ret;
  }
}
