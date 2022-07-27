class countSmaller_1365 {
  public static void main(String[] args) {
    countSmaller_1365 cs = new countSmaller_1365();
    int arr [] = {8,1,2,2,3};
    System.out.println( cs.smallerNumbersThanCurrent(arr));
  }

  public int[] smallerNumbersThanCurrent(int[] nums) {
    int n = nums.length;
    int c[] = new int[101];

    int res[] = new int[nums.length];
    for (int i = 0; i < n; i++) {
      c[nums[i]]++;
    }

    for (int i = 0; i < n; i++) {
      int count = 0;
      for (int j = 0; j < nums[i]; j++)
        count += c[j];
      res[i] = count;
    }
    return res;
  }
}