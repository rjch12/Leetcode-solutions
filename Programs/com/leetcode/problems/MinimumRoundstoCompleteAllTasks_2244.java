/**
 * 2244. Minimum Rounds to Complete All Tasks (https://leetcode.com/problems/minimum-rounds-to-complete-all-tasks/)
 * You are given a 0-indexed integer array tasks, where tasks[i] represents the difficulty level of a task. 
 * In each round, you can complete either 2 or 3 tasks of the same difficulty level.
 * Return the minimum rounds required to complete all the tasks, or -1 if it is not possible to complete all the tasks.
 * 
 * Example 1:
 * Input: tasks = [2,2,3,3,2,4,4,4,4,4]
 * Output: 4
 * Explanation: To complete all the tasks, a possible plan is:
 * - In the first round, you complete 3 tasks of difficulty level 2. 
 * - In the second round, you complete 2 tasks of difficulty level 3. 
 * - In the third round, you complete 3 tasks of difficulty level 4. 
 * - In the fourth round, you complete 2 tasks of difficulty level 4.  
 * It can be shown that all the tasks cannot be completed in fewer than 4 rounds, so the answer is 4.
 * 
 * Example 2:
 * Input: tasks = [2,3,3]
 * Output: -1
 * Explanation: There is only 1 task of difficulty level 2, but in each round, you can only complete 
 * either 2 or 3 tasks of the same difficulty level. Hence, you cannot complete all the tasks, and the answer is -1.
 */

package com.leetcode.problems;

import java.util.HashMap;
import java.util.Map;

public class MinimumRoundstoCompleteAllTasks_2244 {
    public static void main(String[] args) {
        MinimumRoundstoCompleteAllTasks_2244 mt = new MinimumRoundstoCompleteAllTasks_2244();
        // System.out.println(mt.minimumRounds(new int[] { 2, 2, 3, 3, 2, 4, 4, 4, 4, 4
        // }));
        // System.out.println(mt.minimumRounds(new int[] { 5, 5, 5, 5 }));
        System.out.println(mt.minimumRounds(new int[] { 66, 66, 63, 61, 63, 63, 64, 66, 66, 65, 66, 65, 61, 67, 68, 66,
                62, 67, 61, 64, 66, 60, 69, 66, 65, 68, 63, 60, 67, 62, 68, 60, 66, 64, 60, 60, 60, 62, 66, 64, 63, 65,
                60, 69, 63, 68, 68, 69, 68, 61 }));
    }

    public int minimumRounds(int[] tasks) {
        final Map<Integer, Integer> hm = new HashMap<>();
        int rounds = 0;
        for (int i = 0; i < tasks.length; i++) {
            hm.put(tasks[i], hm.getOrDefault(tasks[i], 0) + 1);
        }

        for (int key : hm.keySet()) {
            int noOfTasks = hm.get(key);
            if (noOfTasks % 3 == 0) {
                rounds += (noOfTasks / 3);
            } else if (noOfTasks > 3 && (noOfTasks - 3) % 2 == 0) {
                rounds += noOfTasks / 3;
                rounds += (noOfTasks %= 3) / 2;
            } else if (noOfTasks % 2 == 0)
                rounds += (noOfTasks / 2);
            else
                return -1;
        }
        return rounds;
    }
}
