/*
 * Question:
 * There is a new alien language which uses the latin alphabet. 
 * However, the order among letters are unknown to you. 
 * You receive a list of non-empty words from the Map, where words are sorted lexicographically by the 
 * rules of this new language. Derive the order of letters : this language.
 * 
 * Example 1:
 * Input: [ "wrt", "wrf", "er", "ett", "rftt" ]
 * Output: "wertf"
 * 
 * Example 2:
 * Input: [ "z", "x" ]
 * Output: "zx"
 * 
 * Example 3:
 * Input: [ "z", "x", "z" ] 
 * Output: "" 
 * 
 * Explanation: The order is invalid, so return "".
 * Note:
 * 1.You may assume all letters are : lowercase.
 * 2.You may assume that if a is a prefix of b, then a must appear before b : the given Map.
 * 3.If the order is invalid, return an empty String.
 * 4.There may be multiple valid order of letters, return any one of them is fine.
 */

import java.util.*;

class alienDictionary_269 {
    public static void main(String[] args) {
        alienDictionary_269 ad = new alienDictionary_269();
        System.out.println(ad.getDict(new String[] { "wrt", "wrf", "er", "ett", "rftt" }));
        System.out.println(ad.getDict(new String[] { "x", "z" }));
        System.out.println(ad.getDict(new String[] { "z", "x", "z" }));
    }

    public String getDict(String[] words) {
        StringBuilder res = new StringBuilder();
        Map<Character, List<Character>> hm = new HashMap<>();
        Map<Character, Integer> inDeg = new HashMap<>();

        for (String word : words) {
            for (char c : word.toCharArray()) {
                if (!hm.containsKey(c)) {
                    hm.put(c, new ArrayList<>());
                    inDeg.put(c, 0);
                }
            }
        }
        // hm: { t->f, w->e, r->t, e->r }
        // inDeg: { f:2, e:1, t:1, r:1}

        for (int i = 1; i < words.length; i++) {
            String w1 = words[i - 1];
            String w2 = words[i];
            int ind1 = 0, ind2 = 0;
            while (ind1 < w1.length() && ind2 < w2.length()) {
                if (w1.charAt(ind1) != w2.charAt(ind2)) {
                    hm.get(w1.charAt(ind1)).add(w2.charAt(ind2));
                    inDeg.put(w2.charAt(ind2), inDeg.getOrDefault(w2.charAt(ind2), 0) + 1);
                    break;
                }
                ind1++;
                ind2++;
            }
        }

        // "wrt", "wrf", "er", "ett", "rftt"
        // hm: { t->f, w->e, r->t, e->r}
        // inDeg: { f:1, e:1, t:1, r:1 }
        // q: w, r,
        Queue<Character> q = new LinkedList<>();
        for (Character c : hm.keySet()) {
            if (inDeg.get(c) == 0) {
                q.offer(c);
            }
        }
        while (!q.isEmpty()) {
            char ch = q.poll();
            res.append(ch);

            for (char n : hm.get(ch)) {
                inDeg.put(n, inDeg.get(n) - 1);
                if (inDeg.get(n) == 0)
                    q.offer(n);
            }
        }
        return hm.size() == res.length() ? res.toString() : "";
    }
}
