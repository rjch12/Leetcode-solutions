/*
 * A car travels from a starting position to a destination which is target miles east of the starting position.
 * There are gas stations along the way. The gas stations are represented as an array stations where stations[i] = [positioni, fueli] indicates 
 * that the ith gas station is positioni miles east of the starting position and has fueli liters of gas.
 * The car starts with an infinite tank of gas, which initially has startFuel liters of fuel in it. It uses one liter of gas per one mile that it drives. 
 * When the car reaches a gas station, it may stop and refuel, transferring all the gas from the station into the car.
 * Return the minimum number of refueling stops the car must make in order to reach its destination. If it cannot reach the destination, return -1.
 * Note that if the car reaches a gas station with 0 fuel left, the car can still refuel there. If the car reaches the destination with 0 fuel left, it is still considered to have arrived.
 * 
 * Example 1:
 * Input: target = 1, startFuel = 1, stations = []
 * Output: 0
 * Explanation: We can reach the target without refueling.
 * 
 * Example 2:
 * Input: target = 100, startFuel = 1, stations = [[10,100]]
 * Output: -1
 * Explanation: We can not reach the target (or even the first gas station).
 * 
 * Example 3:
 * Input: target = 100, startFuel = 10, stations = [[10,60],[20,30],[30,30],[60,40]]
 * Output: 2
 * Explanation: We start with 10 liters of fuel.
 * 
 * We drive to position 10, expending 10 liters of fuel.  We refuel from 0 liters to 60 liters of gas.
 * Then, we drive from position 10 to position 60 (expending 50 liters of fuel), and refuel from 10 liters to 50 liters of gas.  
 * We then drive to and reach the target.
 * We made 2 refueling stops along the way, so we return 2.
 */

package com.leetcode.problems;
 
import java.util.PriorityQueue;

public class MinimumNumberofRefuelingStops_871 {
  public static void main(String[] args) {

    MinimumNumberofRefuelingStops_871 mnrs = new MinimumNumberofRefuelingStops_871();
    // mnrs.minRefuelStops(1, 1, new int[][]{{}});
    // mnrs.minRefuelStops(100, 1, new int[][]{{10,100}});
    System.out.println(mnrs.minRefuelStops(100, 10, new int[][] { { 10, 60 }, { 20, 30 }, { 30, 30 }, { 60, 40 } }));
    System.out.println(mnrs.minRefuelStops(1000, 83, new int[][] { { 25, 27 }, {
        36, 187 }, { 140, 186 }, { 378, 6 }, { 492, 202 }, { 517, 89 }, { 579, 234 },
        { 673, 86 }, { 808, 53 }, { 954, 49 } }));
  }

  public int minRefuelStops(int target, int startFuel, int[][] stations) {
    PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
    int res = 0;
    int fuelIHaveCurrently = startFuel;
    int index = 0;

    while (fuelIHaveCurrently < target) {
      while (index < stations.length && fuelIHaveCurrently >= stations[index][0]) {
        pq.offer(stations[index][1]);
        index++;
      }

      if (pq.isEmpty())
        return -1;

      fuelIHaveCurrently += pq.poll();
      res++;
    }
    return res;
  }
}
