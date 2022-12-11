package com.leetcode.problems;

import java.util.Arrays;
import java.util.PriorityQueue;

public class meetingRoomII_253 {
  public static void main(String[] args) {
    meetingRoomII_253 mr2 = new meetingRoomII_253();
    // System.out.println(mr2.minMeetingRooms(new int [][]{{0,30},{5,10},{15,20}}));
    // System.out.println(mr2.minMeetingRooms(new int[][] { { 7, 10 }, { 2, 4 } }));
    System.out.println(mr2.minMeetingRooms(new int[][] { { 5, 8 }, { 6, 8 } }));
    // System.out.println(mr2.minMeetingRooms(new int[][] { { 9, 10 }, { 4, 9 }, { 4, 17 } }));
  }

  public int minMeetingRooms(int[][] intervals) {
    if (intervals.length == 0) {
      return 0;
    } else if (intervals.length == 1) {
      return 1;
    }
    int res = 0;
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    Arrays.sort(intervals, (a, b) -> {
      if (a[0] != b[0])
        return a[0] - b[0];
      else
        return a[1] - b[1];
    });

    for (int i = 0; i < intervals.length - 1; i++) {

      if (pq.isEmpty() || intervals[i][1] > intervals[i + 1][0] || intervals[i][1] <= pq.peek()) {
        res++;
      } else
        pq.poll();
      pq.add(intervals[i][1]);
    }
    return res;
  }
}
