/*
 * The Game of Cards

Part I:

In a game of cards involving 2 players, each player is given 5 cards. There are 13 types of cards, valued from lowest to highest as shown below.

2 3 4 5 6 7 8 9 T J Q K A

Your task is to write a program to determine which player wins. The rules of the game are as follows.
The player with the highest value card wins; if the highest value card of player 1 is A and the highest value card of player 2 is J, then player 1 wins.

If the two players have the same highest value card, the one with the larger number of the highest value card wins; for example if player 1 has 1 card A and player 2 has 2 of card As, then player 2 wins.

In case both players had the same number of their highest value cards, their second highest value cards are compared in the same manner as steps 1 and 2.

If both players had an identical set of cards, then the game is a draw.


Input
A list of size 5 representing the cards of player 1.
A list of size 5 representing the cards of player 2.
Output
A single integer representing the winner.
1 if player 1 has won.
2 if player 2 has won.
0 if there was a draw.


Hints on time complexity: The best possible time complexity for the solution is O(n).
Hints on space complexity: The best possible space complexity for the solution is O(1).

Part II:

Our input now will be a string, having 10 cards, where the first 5 cards being player 1’s cards and the last being player 2’s cards. The cards are separated by a space. Each card is represented by two characters, the first determining the type of the card and the second its suit (H, D, C, S). For the purposes of this task the suits are irrelevant, so you can ignore them (consider the first character only). 

Examples:


Player 1
Player 2
Result
JH KS QC 3D 2D
3H 4S KS QH AD
2
5H 3S JC JD 2D
JD 2H TH TH TS
1
AH KS AC TD 2D
AH 2C 3H 4S AH
1
AH 2S 3C 4D 5D
5C 3S 2H 4S, AH
0
 */

package com.leetcode.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class kijiji_Cards {
    public static void main(String[] args) {
        kijiji_Cards c = new kijiji_Cards();
        List<String> p1 = new ArrayList<>();
        List<String> p2 = new ArrayList<>();

        // 5H 3S JC JD 2D
        // JD 2H TH TH TS
        // AH KS AC TD 2D
        // AH 2C 3H 4S AH
        // AH 2S 3C 4D 5D
        // 5C 3S 2H 4S, AH

        p1.add("AH");
        p1.add("2S");
        p1.add("3C");
        p1.add("4D");
        p1.add("5D");

        p2.add("5C");
        p2.add("3S");
        p2.add("2H");
        p2.add("4S");
        p2.add("AH");

        System.out.println("Winner is: " + c.FindWinner(p1, p2));

    }

    public int FindWinner(List<String> p1, List<String> p2) {
        int winner = 0;
        char[] rankCard = new char[] { '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 'A' };
        Map<Character, Integer> freqMapP1 = new HashMap<>();
        Map<Character, Integer> freqMapP2 = new HashMap<>();

        for (String card : p1) {
            char cardVal = card.charAt(0);
            freqMapP1.put(cardVal, freqMapP1.getOrDefault(cardVal, 0) + 1);
        }

        for (String card : p2) {
            char cardVal = card.charAt(0);
            freqMapP2.put(cardVal, freqMapP2.getOrDefault(cardVal, 0) + 1);
        }

        for (int i = rankCard.length - 1; i >= 0; i--) {
            int freqp1 = 0, freqp2 = 0;

            if (freqMapP1.containsKey(rankCard[i])) {
                freqp1 = freqMapP1.get(rankCard[i]);
            }
            if (freqMapP2.containsKey(rankCard[i])) {
                freqp2 = freqMapP2.get(rankCard[i]);
            }

            if (freqp1 > freqp2)
                return 1;
            else if (freqp2 > freqp1)
                return 2;
        }
        return winner;
    }
}
