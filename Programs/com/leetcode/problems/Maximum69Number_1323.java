/*
 * 1323. Maximum 69 Number (https://leetcode.com/problems/maximum-69-number/)
 * You are given a positive integer num consisting only of digits 6 and 9.
 * Return the maximum number you can get by changing at most one digit (6 becomes 9, and 9 becomes 6).
 * Input: num = 9669
 * Output: 9969
 * Explanation: 
 * Changing the first digit results in 6669.
 * Changing the second digit results in 9969.
 * Changing the third digit results in 9699.
 * Changing the fourth digit results in 9666.
 * The maximum number is 9969.
 */

package com.leetcode.problems;

public class Maximum69Number_1323 {
    public static void main(String[] args) {
        Maximum69Number_1323 m = new Maximum69Number_1323();
        System.out.println(m.maximum69Number(9669));
    }

    public int maximum69Number(int num) {
        String s = String.valueOf(num);
        int res = 0, i;
        for (i = 0; i < s.length(); i++) {
            res = res * 10 + 9;
            if (s.charAt(i) == '6')
                break;
        }
        i++;
        for (; i < s.length(); i++) {
            res = res * 10 + (s.charAt(i) - '0');
        }
        return res;
    }
}
