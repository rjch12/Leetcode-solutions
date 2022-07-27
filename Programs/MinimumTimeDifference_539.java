

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class MinimumTimeDifference_539 {
  public static void main(String[] args) {
    MinimumTimeDifference_539 mtd = new MinimumTimeDifference_539();

    // System.out.println(mtd.findMinDifference(Arrays.asList("00:00","23:59","00:00")));
    // System.out.println(mtd.findMinDifference(Arrays.asList("23:50", "14:00", "14:05", "00:00")));
    // System.out.println(mtd.findMinDifference(Arrays.asList("23:50", "00:00")));
    System.out.println(mtd.findMinDifference(Arrays.asList("00:00","04:00","22:00")));
  }

  public int findMinDifference(List<String> timePoints) {
    int minTime = Integer.MAX_VALUE;
    List<Integer> mins = new ArrayList<>();

    for(String time: timePoints) {
      mins.add((Integer.parseInt(time.substring(0,2)) * 60) + Integer.parseInt(time.substring(3)));
    }
    Collections.sort(mins);
    for (int i = 0; i < mins.size() - 1; ++i) {
      minTime = Math.min(getTimediff(mins.get(i + 1), mins.get(i)), minTime);
    }
    minTime = Math.min(getTimediff(mins.get(mins.size() - 1), mins.get(0)), minTime);
    return minTime;
  }

  public int getTimediff(int t1, int t2) {
    return Math.min((t1 -t2), (1440 - (t1 - t2)));
  }
}
