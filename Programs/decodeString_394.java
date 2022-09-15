import java.util.*;

class decodeString_394 {
  public static void main(String[] args) {
    decodeString_394 ds = new decodeString_394();
    System.out.println(ds.decodeString("3[a]2[bc]"));
    // ds.decodeString("100[leetcode]");
    // ds.decodeString("3[a]2[bc]");
    // System.out.println( ds.decodeString("3[a2[c]]"));
    // System.out.println( ds.decodeString("2[abc]3[cd]ef"));
  }

  public String decodeString3(String s) {
    Stack<Integer> multiplier = new Stack<Integer>();
    Stack<String> alp = new Stack<String>();

    int num = 0;
    String word = "";

    for (Character c : s.toCharArray()) {
      if (Character.isDigit(c))
        num = (num * 10) + (c - '0');

      else if (c == '[') {
        multiplier.push(num);
        alp.push(word);
        word = "";
        num = 0;
      } else if (c >= 'a' && c <= 'z')
        word += c;

      else {
        int multiFactor = multiplier.pop();
        String rep = alp.pop();
        while (multiFactor > 0) {
          rep += word;
          multiFactor--;
        }
        word = rep;
      }
    }
    return word;
  }

  public String decodeString(String s) {
    return decode(s, new int[]{0});
  }

  public String decode(String s, int[] index ){
    StringBuilder word = new StringBuilder();
    int num = 0;
    while(index[0] < s.length()) {
        char ch = s.charAt(index[0]);
        index[0]++;
        if(Character.isDigit(ch)) {
            num = num * 10 + ch - '0';
        }
        else if(ch >= 'a' && ch <= 'z') {
            word.append(ch);
        }
        else if(ch == '[') {
            String innerStr = decode(s, index);
            while(num > 0) {
                word.append(innerStr);
                num--;
            }
        }
        else if(ch == ']')
            break;
    }
    return word.toString();
  }
}

