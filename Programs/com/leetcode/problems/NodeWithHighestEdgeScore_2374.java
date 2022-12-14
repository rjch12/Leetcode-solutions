/*
 * 2374. Node With Highest Edge Score (https://leetcode.com/problems/node-with-highest-edge-score/)
 * You are given a directed graph with n nodes labeled from 0 to n - 1, where each node has exactly 
 * one outgoing edge.
 * 
 * The graph is represented by a given 0-indexed integer array edges of length n, where edges[i] 
 * indicates that there is a directed edge from node i to node edges[i].
 * 
 * The edge score of a node i is defined as the sum of the labels of all the nodes that have an edge pointing to i.
 * 
 * Return the node with the highest edge score. If multiple nodes have the same edge score, 
 * return the node with the smallest index.
 * Example: 
 * Input: edges = [1,0,0,0,0,7,7,5]
 * Output: 7
 * Explanation:
 * - The nodes 1, 2, 3 and 4 have an edge pointing to node 0. The edge score of node 0 is 1 + 2 + 3 + 4 = 10.
 * - The node 0 has an edge pointing to node 1. The edge score of node 1 is 0.
 * - The node 7 has an edge pointing to node 5. The edge score of node 5 is 7.
 * - The nodes 5 and 6 have an edge pointing to node 7. The edge score of node 7 is 5 + 6 = 11.
 * Node 7 has the highest edge score so return 7.
 */

package com.leetcode.problems;

import java.util.HashMap;
import java.util.Map;

public class NodeWithHighestEdgeScore_2374 {
    public static void main(String[] args) {
        NodeWithHighestEdgeScore_2374 n = new NodeWithHighestEdgeScore_2374();
        System.out.println(n.edgeScore(
                new int[] { 25, 27, 27, 21, 39, 30, 38, 17, 36, 23, 23, 2, 34, 39, 11, 36, 15, 29, 35, 36, 39, 3, 30,
                        29, 33, 0, 33, 21, 41, 21, 36, 36, 35, 35, 19, 36, 42, 19, 28, 11, 44, 11, 30, 6, 11 }));
    }

    public int edgeScore(int[] edges) {
        Map<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            hm.put(edges[i], hm.getOrDefault(edges[i], 0) + i);
        }

        int max = 0, res = 0;
        for (int key : hm.keySet()) {
            if (hm.get(key) >= max) {
                if (hm.get(key) == max)
                    res = Math.min(key, res);
                else
                    res = key;
                max = hm.get(key);
            }
        }
        return res;
    }
}
