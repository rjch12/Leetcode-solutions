/** 
 * 290. Word Pattern https://leetcode.com/problems/word-pattern/description/
 * Given a pattern and a string s, find if s follows the same pattern.
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.
 * 
 * Example 1:
 * Input: pattern = "abba", s = "dog cat cat dog"
 * Output: true
 */

package com.leetcode.problems;
 
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordPattern_290 {
    public static void main(String[] args) {
        WordPattern_290 wp = new WordPattern_290();
        System.out.println(wp.wordPattern("abba", "dog cat cat dog"));
    }

    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> hm = new HashMap<>();
        Set<String> hs = new HashSet<>();

        String[] str = s.split(" ");

        if (pattern.length() != str.length)
            return false;
        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            if (hm.containsKey(ch)) {
                if (!hm.get(ch).equals(str[i])) {
                    return false;
                }
            } else if (hs.contains(str[i]))
                return false;
            else {
                hm.put(ch, str[i]);
                hs.add(str[i]);
            }
        }

        return true;
    }
}
