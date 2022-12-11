import java.util.*;
package com.leetcode.problems;

public class MaximumPerformanceofaTeam_1383 {
  public static void main(String[] args) {
    MaximumPerformanceofaTeam_1383 s = new MaximumPerformanceofaTeam_1383();
    System.out.println( s.maxPerformance(6, new int[] {2,10,3,1,5,8}, new int[] {5,4,3,9,7,2}, 2));
  }
  public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
      return dfs(n, speed, efficiency, k, 0, Integer.MAX_VALUE);
  }

  public int dfs(int n, int[] speed, int[] efficiency, int k, int speedSum, int minEfficiency) {
      if(n == 0 || k == 0)
          return speedSum * minEfficiency;
      
      int localEfficiency = Math.min(minEfficiency, efficiency[n-1]);
      int newSpeedSum = speedSum + speed[n-1];
      
      int selected = dfs(n - 1, speed, efficiency, k - 1, newSpeedSum, localEfficiency);
      int notSelected = dfs(n - 1, speed, efficiency, k, speedSum, minEfficiency);
      
      return Math.max(selected, notSelected);
  }

    public int maxPerformance2(int n, int[] speed, int[] efficiency, int k) {
        int mod = (int)(1e9+7);
        int performance[][] = new int [n][2];
        
        for(int i = 0; i < n; i++) {
            performance[i] = new int[]{speed[i], efficiency[i]};
        }
        Arrays.sort(performance, (a,b) -> b[1] - a[1]);
        
        long totalSum = 0, res = Long.MIN_VALUE;
        
        Queue<Integer> pq = new PriorityQueue<>();
        for(int[] i: performance) {
            if(pq.size() == k) 
                totalSum -= pq.poll();
            
            pq.offer(i[0]);
            totalSum += i[0];
            res = Math.max(res, totalSum * i[1]);
        }
        return (int)res % mod;
    }

  public int maxPerformance3(int n, int[] speed, int[] efficiency, int k) {
      int mod = (int)(1e9 + 7);
      int [][] efficient = new int [n][2];
      
      for(int i = 0; i < n; i++){
          efficient[i] = new int[]{speed[i], efficiency[i]};
      }
      
      Arrays.sort(efficient, (a, b) -> b[1] - a[1]);
      
      PriorityQueue<Integer> pq = new PriorityQueue<>();
      
      long totalSpeed = 0, res = Long.MIN_VALUE;
      
      for(int [] arr : efficient){
          if(pq.size() == k){
              totalSpeed -= pq.poll();
          }
          pq.offer(arr[0]);
          totalSpeed += arr[0];
          res = Math.max(res, totalSpeed * arr[1]);
      }
      return (int)(res % mod);
  }
}