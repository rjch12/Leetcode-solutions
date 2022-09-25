import java.util.Map;
import java.util.HashMap;

class maxNumberOfBalloon_1189 {

  public static void main(String[] args) {
    maxNumberOfBalloon_1189 mnb = new maxNumberOfBalloon_1189();
    // System.out.println(mnb.maxNumberOfBalloons("loonbalxballpoon"));
    System.out.println(mnb.maxNumberOfBalloons("ballon"));
  }

  public int maxNumberOfBalloons(String text) {
    Map<Character, Integer> hm = new HashMap<>();
    for (int i = 0; i < text.length(); i++) {
      char ch = text.charAt(i);
      switch (ch) {
        case 'b':
        case 'a':
        case 'l':
        case 'o':
        case 'n':
          hm.put(ch, hm.getOrDefault(ch, 0) + 1);
      }
    }

    if (hm.size() != 5 || hm.get('l') < 2 || hm.get('o') < 2) {
      return 0;
    }

    int min = Integer.MAX_VALUE;

    for (char ch : hm.keySet()) {
      min = Math.min(min, hm.get(ch));
    }
    return min;
  }
}