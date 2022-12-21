/*
 * 886. Possible Bipartition https://leetcode.com/problems/possible-bipartition/description/
 * We want to split a group of n people (labeled from 1 to n) into two groups of any size. 
 * Each person may dislike some other people, and they should not go into the same group.
 * Given the integer n and the array dislikes where dislikes[i] = [ai, bi] indicates that
 * the person labeled ai does not like the person labeled bi, return true if it is possible
 * to split everyone into two groups in this way.
 * Example 1:
 * Input: n = 4, dislikes = [[1,2],[1,3],[2,4]]
 * Output: true
 * Explanation: group1 [1,4] and group2 [2,3].
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class UnionFind {
    int[] parent, rank;

    public UnionFind(int size) {
        parent = new int[size];
        rank = new int[size];
        for (int i = 1; i < size; i++)
            parent[i] = i;

    }

    public int findParent(int x) {
        while (parent[x] != x)
            x = parent[x];
        return x;
    }

    public boolean find(int x, int y) {
        return parent[x] == parent[y];
    }

    public void union(int x, int y) {
        int pX = findParent(x), pY = findParent(y);
        if (pX == pY)
            return;
        else if (rank[pX] < rank[pY])
            parent[pX] = pY;
        else
            parent[pY] = pX;
        rank[pX]++;
    }
}

public class PossibleBipartition_886 {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] pair : dislikes) {
            int a = pair[0], b = pair[1];
            if (!adj.containsKey(a)) {
                adj.put(a, new ArrayList<>());
            }
            if (!adj.containsKey(b)) {
                adj.put(b, new ArrayList<>());
            }
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        UnionFind uf = new UnionFind(n + 1);
        for (int i = 1; i < n + 1; i++) {
            if (!adj.containsKey(i))
                continue;
            for (int neighbours : adj.get(i)) {
                if (uf.find(i, neighbours))
                    return false;
                else {
                    uf.union(neighbours, adj.get(i).get(0));
                }
            }
        }
        return true;
    }
}
