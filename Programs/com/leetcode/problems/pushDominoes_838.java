/*
 * 838. Push Dominoes - https://leetcode.com/problems/push-dominoes/
 * There are n dominoes in a line, and we place each domino vertically upright. 
 * In the beginning, we simultaneously push some of the dominoes either to the left or to the right.
 * After each second, each domino that is falling to the left pushes the adjacent domino on the left. 
 * Similarly, the dominoes falling to the right push their adjacent dominoes standing on the right.
 * When a vertical domino has dominoes falling on it from both sides, it stays still due to the balance of 
 * the forces.
 * 
 * For the purposes of this question, we will consider that a falling domino expends no additional force to a 
 * falling or already fallen domino.
 * 
 * You are given a string dominoes representing the initial state where:
 * 
 * dominoes[i] = 'L', if the ith domino has been pushed to the left,
 * dominoes[i] = 'R', if the ith domino has been pushed to the right, and
 * dominoes[i] = '.', if the ith domino has not been pushed.
 * 
 * Return a string representing the final state.
 * 
 * Example 1:
 * Input: dominoes = "RR.L"
 * Output: "RR.L"
 * Explanation: The first domino expends no additional force on the second domino.
 */
package com.leetcode.problems;

public class pushDominoes_838 {
    public static void main(String[] args) {
        pushDominoes_838 pd = new pushDominoes_838();
        System.out.println(pd.pushDominoes(".L.R...LR..L.."));
    }

    public String pushDominoes(String dominoes) {
        char[] s = dominoes.toCharArray();
        int[] lForce = new int[s.length];
        int[] rForce = new int[s.length];

        int force = 0;
        for (int i = 0; i < s.length - 1; i++) {
            if (s[i] == 'R')
                force = s.length;
            else if (s[i] == 'L')
                force = 0;

            rForce[i] = force--;
        }

        for (int i = s.length - 1; i >= 0; i--) {
            if (s[i] == 'L')
                force = s.length;
            else if (s[i] == 'R')
                force = 0;

            rForce[i] = force--;
        }

        String res = "";
        for (int i = 0; i < s.length - 1; i++) {
            if (lForce[i] > rForce[i])
                res += 'L';
            else if (rForce[i] > lForce[i])
                res += 'R';

            else
                res += '.';
        }

        return res;
    }
}
