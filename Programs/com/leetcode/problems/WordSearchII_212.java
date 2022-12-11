/*
 * https://leetcode.com/problems/word-search-ii/
 * 
 * Given an m x n board of characters and a list of strings words, return all words on the board.
 * Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells 
 * are horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
 * 
 * Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], 
 * words = ["oath","pea","eat","rain"]
 * Output: ["eat","oath"]
 */

package com.leetcode.problems;

import java.util.*;

public class WordSearchII_212 {

    public static void main(String[] args) {
        char[][] board = { { 'o', 'a', 'a', 'n' }, { 'e', 't', 'a', 'e' }, { 'i', 'h', 'k', 'r' },
                { 'i', 'f', 'l', 'v' } };
        String[] words = { "oath", "pea", "eat", "rain" };
        WordSearchII_212 ws = new WordSearchII_212();
        System.out.println(ws.findWords(board, words));
    }

    public List<String> findWords(char[][] board, String[] words) {
        boolean visited[][] = new boolean[board.length][board[0].length];
        Set<String> hs = new HashSet<>();
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, visited, words, i, j, "", res, hs);
            }
        }
        return res;
    }

    public void dfs(char[][] board, boolean[][] v, String words[], int i, int j, String s, List<String> res,
            Set<String> hs) {
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || v[i][j])
            return;
        v[i][j] = true;
        s += board[i][j];
        if (contains(words, s) && !hs.contains(s)) {
            res.add(s);
            hs.add(s);
        }
        dfs(board, v, words, i + 1, j, s, res, hs);
        dfs(board, v, words, i, j + 1, s, res, hs);
        dfs(board, v, words, i - 1, j, s, res, hs);
        dfs(board, v, words, i, j - 1, s, res, hs);
    }

    public boolean contains(String[] word, String s) {
        for (String str : word)
            if (str.equals(s))
                return true;
        return false;
    }
}
