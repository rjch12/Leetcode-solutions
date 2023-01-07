package com.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KeysandRooms_841 {
    public static void main(String[] args) {
        KeysandRooms_841 k = new KeysandRooms_841();
        List<List<Integer>> rooms = new ArrayList<>();
        // rooms.add(Arrays.asList(1));
        // rooms.add(Arrays.asList(2));
        // rooms.add(Arrays.asList(3));
        // rooms.add(new ArrayList<>());

        rooms.add(Arrays.asList(1, 3));
        rooms.add(Arrays.asList(3,0,1));
        rooms.add(Arrays.asList(2));
        rooms.add(new ArrayList<>());
        System.out.println(k.canVisitAllRooms(rooms));
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean visited[] = new boolean[rooms.size()];
        visited[0] = true;  
        List<Integer> firstKey = rooms.get(0);
        Queue<Integer> q = new LinkedList<>();
        for (int i : firstKey)
            q.offer(i);

        visitAll(rooms, q, visited);
        return checkVisited(visited);
    }

    private boolean checkVisited(boolean[] visited) {
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i])
                return false;
        }
        return true;
    }

    public void visitAll(List<List<Integer>> rooms, Queue<Integer> q, boolean[] visited) {

        while (!q.isEmpty()) {
            visited[q.peek()] = true;
            List<Integer> visitingRoomKeys = rooms.get(q.poll());
            for(int i: visitingRoomKeys) {
                if(visited[i])
                    continue;
                q.offer(i);
            }
        }
    }
}