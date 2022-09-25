import java.util.Arrays;

class sumOfEvenNumberOfQueries_985 {
    public static void main(String[] args) {
        sumOfEvenNumberOfQueries_985 s = new sumOfEvenNumberOfQueries_985();
        int[] res = s.sumEvenAfterQueries(new int[] { 1, 2, 3, 4 },
                new int[][] { { 1, 0 }, { -3, 1 }, { -4, 0 }, { 2, 3 } });

        for(int i: res)
        System.out.print(i + " ");
    }

    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int[] res = new int[nums.length];
        int[] temp = Arrays.copyOf(nums, nums.length);
        int ind = 0, totalSum = getEvenSum(nums);
        // [1,2,3,4] [[1,0],[-3,1],[-4,0],[2,3]]
        // totalSum: 8
        // nums: [2,2,3,4]
        // temp: [2,2,3,4]
        // q[0]: -3
        // q[1]: 1
        // res: [8]
        for (int[] q : queries) {
            temp[q[1]] = temp[q[1]] + q[0];
            if (nums[q[1]] % 2 == 0) {
                totalSum = totalSum - nums[q[1]];
            }
            nums[q[1]] = temp[q[1]];
            if (nums[q[1]] % 2 == 0) {
                totalSum = totalSum + nums[q[1]];
            }
            res[ind++] = totalSum;
        }
        return res;
    }

    public int getEvenSum(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i % 2 == 0 ? i : 0;
        }
        return sum;
    }
}