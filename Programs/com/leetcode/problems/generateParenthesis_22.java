package com.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class generateParenthesis_22 {
  List<String> al = new ArrayList<>();

  public static void main(String[] args) {
    generateParenthesis_22 gs = new generateParenthesis_22();

    gs.generateParenthesis(3);
  }

  public List<String> generateParenthesis(int n) {
    getParenthesis(n, n, "");
    return al;
  }

  void getParenthesis(int open, int closed, String S) {

    if (open == 0 && closed == 0) {
      al.add(S);
      return;
    }
    if (open > 0) {
      getParenthesis(open - 1, closed, S + '(');
    }
    if (closed > open) {
      getParenthesis(open, closed - 1, S + ')');
    }
  }
}
