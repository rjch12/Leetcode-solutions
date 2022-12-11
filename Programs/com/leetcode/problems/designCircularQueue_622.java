package com.leetcode.problems;

public class designCircularQueue_622 {
    int[] q;
    int size, front, rear, len;

    public static void main(String[] args) {

        designCircularQueue_622 obj = new designCircularQueue_622(3);
        System.out.println(obj.enQueue(1));
        System.out.println(obj.enQueue(2));
        System.out.println(obj.enQueue(3));
        System.out.println(obj.enQueue(4));
        System.out.println(obj.Rear());
        System.out.println(obj.isFull());
        System.out.println(obj.deQueue());
        System.out.println(obj.enQueue(4));
        System.out.println(obj.Rear());

    }

    public designCircularQueue_622(int k) {
        q = new int[k];
        size = k;
        front = -1;
        rear = 0;
        len = 0;
    }

    // size = 3;
    // f: 0 r: 0
    // fr
    // [0, 0, 0]
    public boolean enQueue(int value) {
        if (isFull())
            return false;
        front = (front + 1) % size;
        q[front] = value;
        len++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty())
            return false;
        len--;
        rear = (rear + 1) % size;
        return true;
    }

    public int Front() {
        return (isEmpty()) ? -1 : q[rear];
    }

    public int Rear() {
        return (isEmpty()) ? -1 : q[front];
    }

    public boolean isEmpty() {
        return len == 0;
    }

    public boolean isFull() {
        return (len == size);
    }
}
