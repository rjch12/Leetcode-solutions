

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

package com.leetcode.problems;

public class snapshotArray_1146 {
  List<int []> snapshots;
  int [] current;
  public static void main(String[] args) {
    snapshotArray_1146 sa = new snapshotArray_1146(3);
    sa.set(0, 5);
    System.out.println( sa.snap());
    sa.set(0, 6);
    System.out.println( sa.get(0, 0));
    // snapshotArray_1146 sa = new snapshotArray_1146(1);
    // sa.set(0, 15);
    // System.out.println( sa.snap());
    // System.out.println( sa.snap());
    // System.out.println( sa.snap());
    // System.out.println( sa.get(0, 2));
    // System.out.println( sa.snap());
    // System.out.println( sa.snap());
    // System.out.println( sa.get(0, 0));
  }

  public snapshotArray_1146(int length) {
    snapshots = new ArrayList<>(length);
    current = new int[length];
  }

  public void set(int index, int val) {
    current[index] = val;
    
  }

  public int snap() {
    snapshots.add(Arrays.copyOf(current, current.length));
    return (snapshots.size() - 1);
  }

  public int get(int index, int snap_id) {
    return snapshots.get(snap_id)[index];
  }
}
