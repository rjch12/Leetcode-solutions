package com.leetcode.problems;

import java.util.TreeMap;

public class MyCalendar_1_729 {
    TreeMap<Integer, Integer> interval;

    public static void main(String[] args) {
        MyCalendar_1_729 m = new MyCalendar_1_729();
        // TC1
        // m.book(10,20);
        // m.book(15,25);
        // m.book(20,30);
        // TC2
        m.book(47, 50);
        m.book(33, 41);
        m.book(39, 45);
        m.book(33, 42);
        m.book(25, 32);
        m.book(26, 35);
        m.book(19, 25);
        m.book(3, 8);
        m.book(8, 13);
        m.book(18, 27);
    }

    public MyCalendar_1_729() {
        interval = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Integer prev = interval.floorKey(start);
        Integer next = interval.ceilingKey(start);

        if ((prev == null || interval.get(prev) <= start)
                && (next == null || end <= next)) {
            interval.put(start, end);
            return true;
        }
        return false;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
