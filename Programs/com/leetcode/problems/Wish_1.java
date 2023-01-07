/* 
 Given an array of String containing code snippet. 
 Remove single line and multi line comments from the array and return a new array
*/
package com.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class Wish_1 {

  public static void main(String[] args) {
    String str = "for(int i=0; i< 10 /*Upper Limit */; i++) {\ni++; // comment1\naBc}";
    Wish_1 w = new Wish_1();
    String[] arr = w.FixCode(str);
    for (String s : arr)
      System.out.println(s);
  }

  public String[] FixCode(String s) {
    List<String> res = new ArrayList<>();
    String[] str = s.split("\n");

    for (String curr : str) {

      // process single line comment;
      if (curr.contains("//")) {
        String[] temp = curr.split("//");
        if (temp[0].length() != 0)
          res.add(temp[0]);
        continue;
      } else
        res.add(curr);
    }

    return res.toArray(new String[res.size()]);
  }
}
