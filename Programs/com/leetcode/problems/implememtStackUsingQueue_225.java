package com.leetcode.problems;

import java.util.*;

public class implememtStackUsingQueue_225 {
  Queue<Integer> first;
  Queue<Integer> second;

  public implememtStackUsingQueue_225() {
    first = new LinkedList<>();
    second = new LinkedList<>();
  }

  public static void main(String[] args) {
    implememtStackUsingQueue_225 obj = new implememtStackUsingQueue_225();
    obj.push(1);
    obj.push(2);
    System.out.println(obj.pop());
    System.out.println(obj.top());
    System.out.println(obj.empty());
  }

  // first - {0}
  // second -
  public void push(int x) {
    second.offer(x);
    while (!first.isEmpty())
      second.offer(first.poll());

    while (!second.isEmpty())
      first.offer(second.poll());
  }

  public int pop() {
    return first.poll();
  }

  public int top() {
    return first.peek();
  }

  public boolean empty() {
    return first.isEmpty();
  }
}
/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
