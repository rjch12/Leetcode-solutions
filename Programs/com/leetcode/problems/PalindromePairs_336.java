package com.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PalindromePairs_336 {
    public static void main(String[] args) {
        PalindromePairs_336 pp = new PalindromePairs_336();
        System.out.println(pp.palindromePairs(new String[] { "abcd", "dcba", "lls", "s", "sssll" }));
    }

    public List<List<Integer>> palindromePairs(String[] words) {
        int len = words.length;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < len; ++i) {
            for (int j = i + 1; j < len; ++j) {
                if (isPalindrome(words[i] + words[j])) {
                    res.add(Arrays.asList(i, j));
                }
                if (isPalindrome(words[j] + words[i])) {
                    res.add(Arrays.asList(j, i));
                }
            }
        }
        return res;
    }

    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }

        }
        return true;
    }
}
