/* 
 * 1155. Number of Dice Rolls With Target Sum (https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/)
 * You have n dice and each die has k faces numbered from 1 to k.
 * Given three integers n, k, and target, return the number of possible ways (out of the kn total ways)
 *  to roll the dice so the sum of the face-up numbers equals target. Since the answer may be too large, 
 * return it modulo 109 + 7.
 * 
 * Example 1:
 * Input: n = 1, k = 6, target = 3
 * Output: 1
 * Explanation: You throw one die with 6 faces.
 * There is only one way to get a sum of 3.
 */

class NumberofDiceRollsWithTargetSum_1155 {
    public static void main(String[] args) {
        NumberofDiceRollsWithTargetSum_1155 n = new NumberofDiceRollsWithTargetSum_1155();
        // System.out.println(n.numRollsToTarget(1, 6, 3));
        System.out.println(n.numRollsToTarget(2, 6, 7));
        // System.out.println(n.numRollsToTarget(30, 30, 500));
    }

    public int numRollsToTarget(int n, int k, int target) {
        return helper(new Integer[n + 1][target + 1], n, k, target);
    }

    public int helper(Integer[][] memo, int n, int k, int target) {
        if (target == 0)
            return 1;
        if (n == 0)
            return 0;
        if (memo[n][target] != null)
            return memo[n][target];

        int res = 0;
        for (int i = 1; i < k; i++) {
            res += helper(memo, n - 1, k, target - i);
        }
        return memo[n][target] = res;
    }
}