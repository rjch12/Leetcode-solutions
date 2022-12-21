/**
 * 198. House Robber https://leetcode.com/problems/house-robber/
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, 
 * the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and 
 * it will automatically contact the police if two adjacent houses were broken into on the same night.
 * Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can 
 * rob tonight without alerting the police.
 * 
 * Example 1:
 * Input: nums = [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 */


class HouseRobber_198 {
    public static void main(String[] args) {
        HouseRobber_198 hr = new HouseRobber_198();
        int houses[] = { 1, 2, 3, 1 };
        System.out.println(hr.rob(houses));
    }

    int max_money;

    public int rob(int[] nums) {
        max_money = Integer.MIN_VALUE;
        return robed(nums, 0, 0);
        // max_money;
    }

    public int robed(int[] nums, int index, int money) {
        if (index >= nums.length)
            return 0;

        money += nums[index];
        max_money = Math.max(money, max_money);

        return Math.max(robed(nums, index + 2, money), robed(nums, index + 1, money));
    }
}