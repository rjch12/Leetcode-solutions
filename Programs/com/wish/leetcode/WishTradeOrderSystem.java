package com.wish.leetcode;

import java.util.PriorityQueue;

class order {
  int quantity;
  float price;

  public order(int q, float p) {
    this.quantity = q;
    this.price = p;
  }
}

public class WishTradeOrderSystem {

  PriorityQueue<order> sellBag = new PriorityQueue<>((a, b) -> a.price > b.price ? -1 : 1);
  PriorityQueue<order> buyBag = new PriorityQueue<>((a, b) -> b.price > a.price ? -1 : 1);

  public static void main(String[] args) {
    WishTradeOrderSystem system = new WishTradeOrderSystem();

    System.out.println(system.sell(50, (float) 1.5));// return: 0
    System.out.println(system.sell(20, (float) 1.4));// return: 0
    System.out.println(system.buy(60, (float) 1.51));// return: 60
    System.out.println(system.buy(20, (float) 1.5));// return: 10
    System.out.println(system.sell(20, (float) 0.7));// return: 10
    System.out.println(system.buy(100, (float) 0.6));// return: 0

  }

  /*
   * buy(num_of_product, price)
   * Called by buyer to buy certain number of products with a maximum price
   * num_of_product (INTEGER): number of products to buy
   * price (FLOAT): maximal price/unit the buyer is willing to pay
   * Return (INTEGER): number of products can be bought
   */
  public int buy(int numProd, float price) {
    int qty = numProd;
    while (!sellBag.isEmpty() && sellBag.peek().price < price && qty > 0) {
      order o = sellBag.peek();

      if (o.quantity > qty) {
        o.quantity = o.quantity - qty;
        qty = 0;
        break;
      } else {
        qty = qty - o.quantity;
        sellBag.poll();
      }
    }

    if (qty != 0) {
      sellBag.offer(new order(qty, price));
    }

    return numProd - qty;
  }

  /*
   * sell(num_of_product, price)
   * Called by seller to sell certain number of products with a minimum price
   * num_of_product (INTEGER): number of products to sell
   * price (FLOAT): minimal price/unit the seller is willing to sell
   * Return (INTEGER): number of products can be sold
   */
  public int sell(int numProd, float price) {
    int qty = numProd;
    while (!buyBag.isEmpty() && numProd > 0 && buyBag.peek().price >= price) {
      order o = buyBag.peek();
      if (o.quantity > qty) {
        o.quantity = o.quantity - qty;
        qty = 0;
        break;
      } else {
        qty = qty - o.quantity;
        buyBag.poll();
      }
    }
    if (qty != 0) {
      sellBag.offer(new order(qty, price));
    }
    return numProd - qty;
  }
}
