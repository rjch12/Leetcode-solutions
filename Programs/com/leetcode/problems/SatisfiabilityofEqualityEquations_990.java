package com.leetcode.problems;

public class SatisfiabilityofEqualityEquations_990 {
    public static void main(String[] args) {
        SatisfiabilityofEqualityEquations_990 s = new SatisfiabilityofEqualityEquations_990();
        System.out.println(s.equationsPossible(new String[] { "a==b", "b!=c", "c==a"
        }));
        System.out.println(s.equationsPossible(new String[] { "f==a", "a==b", "f!=e",
                "a==c", "b==e", "c==f" }));
        // System.out.println(s.equationsPossible(new String[] { "a==b", "e==c", "b==c",
        // "a!=e" }));
    }

    int[] parent = new int[26];

    public int find(int elt) {
        if (parent[elt] == elt)
            return elt;
        return find(parent[elt]);
    }

    public void union(int x, int y) {
        int Px = find(x), Py = find(y);
        if (Px != Py)
            parent[Py] = Px;
    }

    public boolean equationsPossible(String[] equations) {
        for (int i = 0; i < 26; i++)
            parent[i] = i;

        for (String exp : equations) {
            char[] expr = exp.toCharArray();
            if (expr[1] == '=') {
                union(expr[0] - 'a', expr[3] - 'a');
            }
        }

        for (String exp : equations) {
            char[] expr = exp.toCharArray();
            if (expr[1] == '!') {
                if (find(expr[0] - 'a') == find(expr[3] - 'a'))
                    return false;
            }
        }
        return true;
    }
}
