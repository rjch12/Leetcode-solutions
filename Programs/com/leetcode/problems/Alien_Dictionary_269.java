/*
 * Question: There is a new alien language which uses the latin alphabet. 
 * However, the order among letters are unknown to you. 
 * You receive a list of non-empty words from the Map, where words are sorted lexicographically 
 * by the rules of this new language. Derive the order of letters : this language.
 * 
 * Example 1:
 * Input: 
 * ["wrt", "wrf", "er", "ett", "rftt"]
 * Output: "wertf"
 * 
 * Example 2:
 * Input:
 * ["z","x"]
 * Output: "zx"
 * 
 * Example 3:
 * Input:
 * ["z", "x", "z"]
 * Output: ""
 * Explanation: The order is invalid, so return "".
 * Note:
 * 1.You may assume all letters are : lowercase.
 * 2.You may assume that if a is a prefix of b, then a must appear before b : the given Map.
 * 3.If the order is invalid, return an empty String.
 * 4.There may be multiple valid order of letters, return any one of them is fine.
 */
package com.leetcode.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Alien_Dictionary_269 {
  public static void main(String[] args) {
    Alien_Dictionary_269 ad = new Alien_Dictionary_269();
    // System.out.println(ad.getDict(new String[] { "wrt", "wrf", "er", "ett",
    // "rftt" }));
    // System.out.println(ad.getDict(new String[] { "z", "x", "z" }));
    System.out.println(ad.getDict(new String[] { "z", "x", "a" }));
  }

  public String getDict(String[] words) {
    StringBuilder sb = new StringBuilder();
    Map<Character, List<Character>> graph = new HashMap<>();
    Map<Character, Integer> inDeg = new HashMap<>();

    for (String s : words) {
      for (char c : s.toCharArray()) {
        graph.put(c, new ArrayList<>());
        inDeg.put(c, 0);
      }
    }

    for (int i = 1; i < words.length; i++) {
      String first = words[i - 1];
      String sec = words[i];

      int maxLen = Math.min(first.length(), sec.length());

      // an, ant
      if (first.length() > sec.length() && first.substring(0, maxLen).equals(sec)) {
        return "";
      }
      // construct graph and add indegrees
      for (int j = 0; j < maxLen; j++) {
        if (first.charAt(j) != sec.charAt(j)) {
          List<Character> neighbours = graph.get(first.charAt(j));
          neighbours.add(sec.charAt(j));
          graph.put(first.charAt(j), neighbours);
          inDeg.put(sec.charAt(j), inDeg.get(sec.charAt(j)) + 1);
          break;
        }
      }
    }

    // Topological sort
    Queue<Character> q = new LinkedList<>();
    for (Character c : graph.keySet()) {
      if (inDeg.get(c) == 0)
        q.offer(c);
    }

    while (!q.isEmpty()) {
      char node = q.poll();
      sb.append(node);
      List<Character> neighbours = graph.get(node);
      for (Character n : neighbours) {
        inDeg.put(n, inDeg.get(n) - 1);
        if (inDeg.get(n) == 0)
          q.offer(n);
      }
    }
    if (sb.length() != graph.size())
      return "";
    return sb.toString();
  }
}
