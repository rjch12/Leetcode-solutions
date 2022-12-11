package com.leetcode.problems;

package com.leetcode.problems;

public class ArithmeticSlices_413 {
    public static void main(String[] args) {
        ArithmeticSlices_413 as = new ArithmeticSlices_413();
        System.out.println( as.numberOfArithmeticSlices(new int[]{1,2,3,4}));
    }
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums.length < 3) {
            return 0;
        }
        // nums:   [1,2,3,4]
        // nums[i]: 1
        // nums[j]: 2
        // diff: 1
        int res = 0;
        for(int i = 0; i < nums.length - 2; i++) {
            int diff = nums[i+1] - nums[i];

            for(int j = i + 1; j < nums.length; j++) {
                if(nums[j] - nums[j-1] == diff) {
                    if(j - i >= 2)
                        res++;
                }
                else {
                    i = j;
                    break;
                }
            }
        }
        return res;
    }
}