

/**
 * Find duplicate element in O(n) and constant extra space.
 */
import java.util.*;
class duplicateElements {

  // when find a number i, flip the number at position i-1 to negative. 
    // if the number at position i-1 is already negative, i is the number that occurs twice.
    
    // public List<Integer> findDuplicates(int[] nums) {
    //     List<Integer> res = new ArrayList<>();
    //     for (int i = 0; i < nums.length; ++i) {
    //         int index = Math.abs(nums[i])-1;
    //         if (nums[index] < 0)
    //             res.add(Math.abs(index+1));
    //         nums[index] = -nums[index];
    //     }
    //     return res;
    // }
    public List<Integer> findDuplicates(int[] nums) {
      List<Integer> res = new ArrayList<>();
      for(int i = 0; i< nums.length; ++i){
          int index = Math.abs(nums[i]) - 1;
          if(nums[index] < 0){
              res.add(Math.abs(nums[i]));
          }
          nums[index] = -nums[index];
      }
      return res;
  }

  public static void main(String otfs[]){
      duplicateElements dE = new duplicateElements();
      int[] a = {4,3,2,7,8,2,3,1};
      System.out.println(dE.findDuplicates(a));
    }
}
