package com.leetcode.problems;

public class validParanthesisString_678 {
  public static void main(String[] args) {
    validParanthesisString_678 vps = new validParanthesisString_678();
    System.out.println(vps.checkValidString(
        "(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())"
    // "(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())"
    ));
  }

  // "((((()(()()()*()(((((*)()*(**(())))))(())()())(((())())())))))))(((((())*)))()))(()((*()*(*)))(*)()"
  public boolean checkValidString(String s) {
    if (s.length() < 2) {
      return false;
    }
    int star = 0, open = 0, close = 0;
    for (char ch : s.toCharArray()) {
      if (ch == '(')
        open++;
      else if (ch == ')')
        close++;
      else {
        star++;
      }
    }
    if (Math.abs((open - close)) > star)
      return false;
    return true;
  }
}
