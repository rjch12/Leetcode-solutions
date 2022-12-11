package com.leetcode.problems;

public class DoubleLinkedList {
  DoubleLinkedList next;
  DoubleLinkedList previous;
  int val;

  public DoubleLinkedList(int value) {
    this.next = null;
    this.previous = null;
    this.val = value;
  }

  public DoubleLinkedList() {
  }

  public DoubleLinkedList(int value, DoubleLinkedList n, DoubleLinkedList p) {
    this.next = n;
    this.previous = p;
    this.val = value;
  }
}
