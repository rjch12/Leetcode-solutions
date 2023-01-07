/**
 * 944. Delete Columns to Make Sorted
 * You are given an array of n strings strs, all of the same length.
 * The strings can be arranged such that there is one on each line, making a grid. For example, strs = ["abc", "bce", "cae"] can be arranged as:
 * abc
 * bce
 * cae
 * You want to delete the columns that are not sorted lexicographically. In the above example (0-indexed), columns 0 ('a', 'b', 'c') and 2 ('c', 'e', 'e') 
 * are sorted while column 1 ('b', 'c', 'a') is not, so you would delete column 1.
 * Return the number of columns that you will delete.
 * 
 * Input: strs = ["cba","daf","ghi"]
 * Output: 1
 * Explanation: The grid looks as follows:
 *   cba
 *   daf
 *   ghi
 * Columns 0 and 2 are sorted, but column 1 is not, so you only need to delete 1 column.
 */

package com.leetcode.problems;

public class DeleteColumnstoMakeSorted_944 {
    public static void main(String[] args) {
        DeleteColumnstoMakeSorted_944 ds = new DeleteColumnstoMakeSorted_944();
        System.out.println(ds.minDeletionSize(new String[] { "cba", "daf", "ghi" }));
    }

    public int minDeletionSize(String[] strs) {
        char[][] grid = new char[strs.length][strs[0].length()];
        int index = 0, res = 0;
        for (String s : strs) {
            grid[index++] = s.toCharArray();
        }

        for (int col = 0; col < grid[0].length; col++) {
            for (index = 0; index < grid.length - 1; index++) {
                if (grid[index][col] > grid[index + 1][col]) {
                    res++;
                    break;
                }
            }
        }
        return res;
    }
}