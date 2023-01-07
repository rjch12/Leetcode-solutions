/**
 * 452. Minimum Number of Arrows to Burst Balloons (https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/)
 * There are some spherical balloons taped onto a flat wall that represents the XY-plane. The balloons are represented as a 2D 
 * integer array points where points[i] = [xstart, xend] denotes a balloon whose horizontal diameter stretches between xstart and xend. 
 * You do not know the exact y-coordinates of the balloons.
 * 
 * Arrows can be shot up directly vertically (in the positive y-direction) from different points along the x-axis. A balloon with xstart 
 * and xend is burst by an arrow shot at x if xstart <= x <= xend. There is no limit to the number of arrows that can be shot. A shot 
 * arrow keeps traveling up infinitely, bursting any balloons in its path.
 * 
 * Given the array points, return the minimum number of arrows that must be shot to burst all balloons.
 * Example 1:
 * 
 * Input: points = [[10,16],[2,8],[1,6],[7,12]]
 * Output: 2
 * Explanation: The balloons can be burst by 2 arrows:
 * - Shoot an arrow at x = 6, bursting the balloons [2,8] and [1,6].
 * - Shoot an arrow at x = 11, bursting the balloons [10,16] and [7,12].
 */
package com.leetcode.problems;

import java.util.PriorityQueue;

public class MinimumNumberofArrowstoBurstBalloons_452 {
    public static void main(String[] args) {
        MinimumNumberofArrowstoBurstBalloons_452 mb = new MinimumNumberofArrowstoBurstBalloons_452();
        // System.out.println(mb.findMinArrowShots(new int[][] { { 1, 2 }, { 3, 4 }, { 5, 6 }, { 7, 8 } }));
        System.out.println(
                mb.findMinArrowShots(new int[][] { { -2147483646, -2147483645 }, { 2147483646, 2147483647 } }));
    }

    public int findMinArrowShots(int[][] points) {
        int arrows = 1;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        for (int[] balloon : points) {
            pq.offer(balloon);
        }

        while (!pq.isEmpty()) {
            int[] interval = pq.poll();
            while (!pq.isEmpty() && interval[1] >= pq.peek()[0] && interval[1] <= pq.peek()[1]) {
                pq.poll();
            }
            arrows++;
        }
        return arrows;
    }
}
