package com.leetcode.problems;

import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;

public class minAreaRectt {
    public static void main(String[] args) {
        minAreaRectt mar = new minAreaRectt();
        int[][] points = { { 1, 1 }, { 1, 3 }, { 3, 1 }, { 3, 3 }, { 2, 2 } };
        System.out.println(mar.minAreaRect(points));
    }

    public int minAreaRect(int[][] points) {
        Map<Integer, HashSet<Integer>> hm = new HashMap<>();
        for (int[] p : points) {
            if (!hm.containsKey(p[0])) {
                hm.put(p[0], new HashSet<>());
            }
            hm.get(p[0]).add(p[1]);
        }
        int min = Integer.MAX_VALUE;

        for (int[] p1 : points) {
            for (int[] p2 : points) {
                if ((p1[0] == p2[0]) || (p1[1] == p2[1]))
                    continue;

                if (hm.get(p2[0]).contains(p1[1]) && hm.get(p1[0]).contains(p2[1])) {
                    min = Math.min(min, (Math.abs(p2[0] - p1[0]) * Math.abs(p2[1] - p1[1])));
                }
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;

    }
}
