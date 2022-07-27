

import java.util.PriorityQueue;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

class stockPrice_2034 {

  PriorityQueue<Integer> pmax;
  PriorityQueue<Integer> pmin;
  Map<Integer, Integer> hm;
  int current;

  public stockPrice_2034() {
    pmin = new PriorityQueue<>();
    pmax = new PriorityQueue<>(Collections.reverseOrder());
    hm = new HashMap<>();
  }

  public static void main(String[] args) {
    stockPrice_2034 sp = new stockPrice_2034();
    sp.update(1, 10);
    sp.update(2, 5);
    sp.current();
    sp.maximum();
    sp.update(1, 3);
    sp.maximum();
    sp.update(4, 2);
    sp.minimum();
  }

  public void update(int timestamp, int price) {
    int oldprice = 0;
    current = price;
    if (hm.containsKey(timestamp)) {
      oldprice = hm.get(timestamp);
    }
    hm.put(timestamp, price);
    pmax.remove(oldprice);
    pmin.remove(oldprice);
    pmax.add(price);
    pmin.add(price);
  }

  public int current() {
    System.out.println(current);
    return current;
  }

  public int maximum() {
    System.out.println(pmax.peek());
    return pmax.peek();
  }

  public int minimum() {
    System.out.println(pmin.peek());
    return pmin.peek();
  }
}
