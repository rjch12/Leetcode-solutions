class TrappingRainWater_42 {
  public static void main(String[] args) {
    TrappingRainWater_42 trw = new TrappingRainWater_42();
    System.out.println(trw.trap(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 }));
  }

  public int trap(int[] height) {
    int n = height.length, max = 0, rightMax = height[n - 1];

    int left[] = new int[n];
    left[0] = height[0];
    for (int i = 1; i < n; i++) {
      left[i] = Math.max(left[i - 1], height[i]);
    }

    for (int i = n - 1; i >= 0; i--) {
      if (height[i] > rightMax)
        rightMax = height[i];

      max += Math.min(left[i], rightMax) - height[i];
    }
    return max;
  }

  public int trap2(int[] height) {
    int n = height.length;

    int left[] = new int[n];
    left[0] = height[0];
    for (int i = 1; i < n; i++) {
      left[i] = Math.max(left[i - 1], height[i]);
    }
    int right[] = new int[n];
    right[n - 1] = height[n - 1];

    for (int i = n - 2; i >= 0; i--) {
      right[i] = Math.max(right[i + 1], height[i]);
    }
    int max = 0;

    for (int i = 0; i < n; i++) {
      max += Math.min(left[i], right[i]) - height[i];
    }
    return max;
  }

}
