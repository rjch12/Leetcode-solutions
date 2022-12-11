package com.leetcode.problems;

import java.util.Map;
import java.util.HashMap;

public class loggerRateLimiter_359 {

  Map<String, Integer> hm;
  int interval;

  public loggerRateLimiter_359() {
    hm = new HashMap<>();
    interval = 10;
  }

  public static void main(String[] args) {
    loggerRateLimiter_359 lrl = new loggerRateLimiter_359();

    System.out.println(lrl.shouldPrintMessage(1, "foo"));
    System.out.println(lrl.shouldPrintMessage(2, "bar"));
    System.out.println(lrl.shouldPrintMessage(3, "foo"));
    System.out.println(lrl.shouldPrintMessage(8, "bar"));
    System.out.println(lrl.shouldPrintMessage(10, "foo"));
    System.out.println(lrl.shouldPrintMessage(11, "foo"));
  }

  public boolean shouldPrintMessage(int timestamp, String message) {
    if (hm.containsKey(message)) {
      if (timestamp < hm.get(message)) {
        return false;
      }
    }

    hm.put(message, timestamp + interval);
    return true;
  }
}
