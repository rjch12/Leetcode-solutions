/*
 * An integer array original is transformed into a doubled array changed by appending twice the value of every 
 * element in original, and then randomly shuffling the resulting array.
 * 
 * Given an array changed, return original if changed is a doubled array. 
 * If changed is not a doubled array, return an empty array. 
 * The elements in original may be returned in any order.
 * 
 * Input: changed = [1,3,4,2,6,8]
 * Output: [1,3,4]
 * Explanation: One possible original array could be [1,3,4]:
 * - Twice the value of 1 is 1 * 2 = 2.
 * - Twice the value of 3 is 3 * 2 = 6.
 * - Twice the value of 4 is 4 * 2 = 8.
 * Other original arrays could be [4,3,1] or [3,1,4].
 */

import java.util.*;

class FindOriginalArrayFromDoubledArray_2007 {
  public static void main(String[] args) {
    FindOriginalArrayFromDoubledArray_2007 f = new FindOriginalArrayFromDoubledArray_2007();
    int[] arr = f.findOriginalArray(new int[] { 1, 3, 4, 2, 6, 8 });
    // int []arr = f.findOriginalArray(new int[]{6,3,0,1});
    // int []arr = f.findOriginalArray(new int[]{1});
    for (int i : arr)
      System.out.print(i + " ");
    System.out.println();
  }

  public int[] findOriginalArray(int[] changed) {
    Map<Integer, Integer> freq = new HashMap<>();
    int[] res = new int[changed.length / 2];
    int resindex = 0;
    Arrays.sort(changed);
    for (int i = changed.length - 1; i >= 0; i--) {
      if (freq.containsKey(changed[i] * 2)) {
        res[resindex++] = changed[i];
        int newFreq = freq.get(changed[i] * 2) - 1;
        if (newFreq == 0)
          freq.remove(changed[i] * 2);
        else
          freq.put(changed[i] * 2, newFreq);
      } else
        freq.put(changed[i], freq.getOrDefault(changed[i], 0) + 1);
    }
    if (!freq.isEmpty()) {
      return new int[0];
    }
    return res;
  }
}