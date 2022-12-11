package com.leetcode.problems;

import java.util.*;

public class MyCalendar_2_731 {
    TreeMap<Integer, Integer> interval;

    public static void main(String[] args) {
        MyCalendar_2_731 m = new MyCalendar_2_731();
        // TC1
        // m.book(10,20);
        // m.book(15,25);
        // m.book(20,30);
        // TC2
        // m.book(47,50);
        // m.book(33,41);
        // m.book(39,45);
        // m.book(33,42);
        // m.book(25,32);
        // m.book(26,35);
        // m.book(19,25);
        // m.book(3,8);
        // m.book(8,13);
        // m.book(18,27);
        // ["MyCalendarTwo","book","book","book","book","book","book"]
        m.book(10, 20);
        m.book(50, 60);
        m.book(10, 40);
        m.book(5, 15);
        m.book(5, 10);
        m.book(25, 55);
    }

    public MyCalendar_2_731() {
        interval = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        interval.put(start, interval.getOrDefault(start, 0) + 1);
        interval.put(end, interval.getOrDefault(end, 0) - 1);

        int active = 0;

        for (int val : interval.values()) {
            active += val;
            if (active > 2) {
                interval.put(start, interval.get(start) - 1);
                interval.put(end, interval.get(end) + 1);
                return false;
            }

        }
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
