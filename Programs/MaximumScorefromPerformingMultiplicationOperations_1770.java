import java.util.*;

class MaximumScorefromPerformingMultiplicationOperations_1770 {
  public static void main(String[] args) {
    MaximumScorefromPerformingMultiplicationOperations_1770 m = new MaximumScorefromPerformingMultiplicationOperations_1770();
    System.out.println(m.maximumScore(new int[] { 1, 2, 3 }, new int[] { 3, 2, 1 }));
    System.out.println(m.maximumScore(
        new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
        new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
            1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }));
  }

  public int maximumScore(int[] nums, int[] multipliers) {
    Integer[][] memo2 = new Integer[nums.length + 1][multipliers.length + 1];
    int[][] memo = new int[nums.length + 1][multipliers.length + 1];
    for (int[] arr : memo)
      Arrays.fill(arr, -1);
    System.out.println( dp(memo2, nums, multipliers, 0, 0));
    // System.out.println(  getScore(memo, nums, multipliers, 0, 0));
    return 1;
  }

  public int getScore(int[][] memo, int[] nums, int[] mul, int op, int left) {
    int n = nums.length;
    if (op == mul.length)
      return 0;

    if (memo[left][op] != -1)
      return memo[left][op];

    int start = nums[left] * mul[op] + getScore(memo, nums, mul, op + 1, left + 1);
    int end = nums[(n - 1) - (op - left)] * mul[op] + getScore(memo, nums, mul, op + 1, left);

    return memo[left][op] = Math.max(start, end);
  }
   int dp(Integer[][] memo, int[] nums, int[] multipliers, int op, int left) {
      // For Right Pointer
      int n = nums.length;
      if (op == multipliers.length) {
          return 0;
      }
      
      // If already computed, return
      if (memo[op][left] != null) {
          return memo[op][left];
      }
      
      int l = nums[left] * multipliers[op] + dp(memo, nums, multipliers, op + 1, left + 1);
      int r = nums[(n - 1) - (op - left)] * multipliers[op] + dp(memo, nums, multipliers, op + 1, left);
      
      return memo[op][left] = Math.max(l, r);
  }
 
}
