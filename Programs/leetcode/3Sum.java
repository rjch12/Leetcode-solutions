package leetcode;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class ThreeSum {
  public static void main(String[] args) {
      ThreeSum ts = new ThreeSum();
      System.out.println(ts.threeSum(new int []{-1,0,1,2,-1,-4}));

  }
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if(nums.length < 3) {
            return ans;
        }
        
        for(int i = 0; i < nums.length; i++) {
            List<Integer> twoSum = new ArrayList<>();
            twoSum = twoSumm(nums, i, 0 - nums[i]);
            Collections.sort(twoSum);
            if(!twoSum.isEmpty() && !ans.contains(twoSum)) {
                ans.add(twoSum);
            }
        }
        return ans;
        
    }
    
    public List<Integer> twoSumm(int[] nums, int index, int target) {
        Set<Integer> hs = new HashSet<>();
        for(int i = 0; i < nums.length; ++i) {
            if(i == index) {
                continue;
            }
            if(hs.contains(target - nums[i])) {
                return Arrays.asList(target - nums[i], nums[i], 0 - target);
            }
            else
                hs.add(nums[i]);       
        }
        return Arrays.asList();
    }
}
