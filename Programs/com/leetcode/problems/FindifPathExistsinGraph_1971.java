/*
 * 1971. Find if Path Exists in Graph https://leetcode.com/problems/find-if-path-exists-in-graph/
 * There is a bi-directional graph with n vertices, where each vertex is labeled from 0 to n - 1 (inclusive). 
 * The edges in the graph are represented as a 2D integer array edges, where each edges[i] = [ui, vi] denotes a bi-directional edge between vertex ui and vertex vi. 
 * Every vertex pair is connected by at most one edge, and no vertex has an edge to itself.
 * You want to determine if there is a valid path that exists from vertex source to vertex destination.
 * Given edges and the integers n, source, and destination, return true if there is a valid path from source to destination, or false otherwise.
 * 
 * Input: n = 3, edges = [[0,1],[1,2],[2,0]], source = 0, destination = 2
 * Output: true
 * Explanation: There are two paths from vertex 0 to vertex 2:
 * - 0 → 1 → 2
 * - 0 → 2 
 */
package com.leetcode.problems;

public class FindifPathExistsinGraph_1971 {
    public static void main(String[] args) {
        FindifPathExistsinGraph_1971 f = new FindifPathExistsinGraph_1971();
        final int[][] edges = { { 4, 3 }, { 1, 4 }, { 4, 8 }, { 1, 7 }, { 6, 4 }, { 4, 2 }, { 7, 4 }, { 4, 0 },
                { 0, 9 }, { 5, 4 } };
        System.out.println(f.validPath(10, edges, 5, 9));
    }

    int[] parent;

    private void init(int size) {
        parent = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }

    private boolean validPath(int n, int[][] edges, int source, int destination) {
        init(n);
        for (int[] edge : edges) {
            union(edge[0], edge[1]);
        }
        return find(source, destination);
    }

    private void union(int x, int y) {
        if (x != y) {
            int parentX = getparent(x);
            int parentY = getparent(y);
            if (parentX != parentY) {
                parent[parentX] = parentY;
            }
        }
    }

    private int getparent(int i) {
        while (parent[i] != i)
            i = parent[i];
        return i;
    }

    private boolean find(int source, int destination) {
        return parent[source] == parent[destination];
    }
}
