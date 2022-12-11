package com.leetcode.problems;

public class CountAndSay_38 {
    public static void main(String[] args) {
        CountAndSay_38 cs = new CountAndSay_38();
        System.out.println(cs.countAndSay(30));
    }

    public String countAndSay(int n) {
        if (n == 1)
            return "1";
        return count(n, 1, "1");
    }

    public String count(int n, int start, String s) {
        if (start == n)
            return s;
        else {
            return count(n, start + 1, getCount(s));
        }
    }

    public String getCount(String str) {
        StringBuilder sb = new StringBuilder();
        char[] s = str.toCharArray();
        char rem = s[0];
        int count = 1;
        for (int i = 1; i < s.length; i++) {
            if (s[i - 1] == s[i])
                count++;
            else {
                sb.append(count + "" + rem);
                rem = s[i];
                count = 1;
            }
        }
        sb.append(count + "" + rem);
        return sb.toString();
    }
}
