

import java.util.Map;
import java.util.HashMap;

class bullsnCown_299 {
  public static void main(String[] args) {
    bullsnCown_299 bnc = new bullsnCown_299();
    // System.out.println(bnc.getHint("1807", "7810"));
    // System.out.println(bnc.getHint("1123", "0111"));
    System.out.println(bnc.getHint("1234", "4321"));
  }

  public String getHint(String secret, String guess) {
    char[] sec = secret.toCharArray();
    char[] gue = guess.toCharArray();

    int len = sec.length, cow = 0, bull = 0;
    Map<Character, Integer> hm = new HashMap<>();

    for (int i = 0; i < len; i++) {
      if (sec[i] == gue[i]) {
        bull++;
        gue[i] = 'A';
      }
      else
        hm.put(sec[i], hm.getOrDefault(sec[i], 0) + 1);
    }

    for(char ch: gue) {
      if(ch != 'A' && hm.containsKey(ch) && hm.get(ch) > 0) {
        hm.put(ch, hm.get(ch) - 1);
        cow++;

      }
    }
    return (bull +"A"+cow+"B");
  }
}
