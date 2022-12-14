/*
 * You are given a list of airline tickets where tickets[i] = [fromi, toi] represent the departure 
 * and the arrival airports of one flight. Reconstruct the itinerary in order and return it.
 * 
 * All of the tickets belong to a man who departs from "JFK", thus, the itinerary must begin with "JFK". 
 * If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical 
 * order when read as a single string.
 * 
 * For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
 * You may assume all tickets form at least one valid itinerary. You must use all the tickets 
 * once and only once.
 */

package com.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class reconstructItenary_332 {

  public static void main(String[] args) {
    reconstructItenary_332 ri = new reconstructItenary_332();
    String route[][] = new String[][] { { "JFK", "KUL" }, { "JFK", "NRT" }, { "NRT", "JFK" } };
    List<List<String>> ticket = new ArrayList<>();

    for (String[] r : route)
      ticket.add(Arrays.asList(r));

    System.out.println(ri.findItinerary(ticket));
  }

  public List<String> findItinerary(List<List<String>> tickets) {
    Map<String, PriorityQueue<String>> edges = new HashMap<>();

    for (List<String> route : tickets) {
      String from = route.get(0);
      String to = route.get(1);

      if (edges.containsKey(from))
        edges.get(from).offer(to);
      else {
        PriorityQueue<String> pq = new PriorityQueue<>();

        pq.offer(to);
        edges.put(from, pq);
      }
    }

    List<String> res = new ArrayList<>();
    topologicalSort(edges, "JFK", res);
    return res;

  }

  public void topologicalSort(Map<String, PriorityQueue<String>> edges, String source, List<String> res) {

    res.add(0, source);
    if (edges.containsKey(source)) {
      PriorityQueue<String> nextStop = edges.get(source);
      while (!nextStop.isEmpty()) {
        String stop = nextStop.poll();
        topologicalSort(edges, stop, res);
      }
    }
  }
}
