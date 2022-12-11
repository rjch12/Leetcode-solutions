/* 
 * 997. Find the Town Judge (https://leetcode.com/problems/find-the-town-judge/)
 * 
 * In a town, there are n people labeled from 1 to n. There is a rumor that one of these people is secretly 
 * the town judge.
 * If the town judge exists, then:
 *     The town judge trusts nobody.
 *     Everybody (except for the town judge) trusts the town judge.
 *     There is exactly one person that satisfies properties 1 and 2.
 * 
 * You are given an array trust where trust[i] = [ai, bi] representing that the person labeled ai trusts the
 * person labeled bi.
 * 
 * Return the label of the town judge if the town judge exists and can be identified, or return -1 otherwise.
 */

package com.leetcode.problems;

public class FindtheTownJudge_997 {
    public static void main(String[] args) {
        FindtheTownJudge_997 f = new FindtheTownJudge_997();
        // System.out.println( f.findJudge(3, new int[][]{{1,3}, {2,3}, {3,1}}));
        System.out.println(f.findJudge(2, new int[][] { { 1, 2 } }));
    }

    public int findJudge(int n, int[][] trust) {
        int[] trustedBy = new int[n];

        for (int t[] : trust) {
            trustedBy[t[0] - 1]--;
            trustedBy[t[1] - 1]++;
        }

        for (int i = 0; i < n; i++) {
            if (trustedBy[i] == n - 1)
                return i;
        }
        return -1;
    }
}
