/**
 * 520. Detect Capital (https://leetcode.com/problems/detect-capital/description/)
 * We define the usage of capitals in a word to be right when one of the following cases holds:
 * 
 * All letters in this word are capitals, like "USA".
 * All letters in this word are not capitals, like "leetcode".
 * Only the first letter in this word is capital, like "Google".
 * Given a string word, return true if the usage of capitals in it is right.
 * 
 * Example 1:
 * Input: word = "USA"
 * Output: true
 */

package com.leetcode.problems;

public class DetectCapital_520 {
    public static void main(String[] args) {
        DetectCapital_520 dc = new DetectCapital_520();

        System.out.println(dc.detectCapitalUse("ffffffF"));
        System.out.println(dc.detectCapitalUse("Google"));
    }

    public boolean detectCapitalUse(String word) {
        int upperCase = 0;
        for (char ch : word.toCharArray()) {
            upperCase += Character.isUpperCase(ch) ? 1 : 0;
        }
        if (upperCase == word.length() || upperCase == 0 || (upperCase == 1 && Character.isUpperCase(word.charAt(0))))
            return true;

        return false;
    }
}
