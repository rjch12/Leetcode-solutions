

import java.util.Stack;

class BackspaceStringCompare {
  public static void main(String[] args) {
    BackspaceStringCompare bsc = new BackspaceStringCompare();
    System.out.println(bsc.backspaceCompare("xywrrmp", "xywrrmu#p"));
  }  

  public boolean backspaceCompare(String s, String t) {
    Stack <Character> sts = new Stack<>();
    Stack <Character> stt = new Stack<>();
    char c;
    for(int i = 0; i < s.length(); i++) {
        c = s.charAt(i);
        if(c == '#') {
          if(!sts.isEmpty())
            sts.pop();
        }
        else
          sts.push(c);
    }
    for(int i = 0; i < t.length(); i++) {
        c = t.charAt(i);
        if(c == '#') {
          if(!stt.isEmpty())
            stt.pop();
        }
        else
          stt.push(c);
    }

    while(!stt.isEmpty() && !sts.isEmpty()) {
        if(stt.pop() != sts.pop()) {
            return false;
        }
    }
    if(!stt.isEmpty() || !sts.isEmpty())
            return false;
    return true;
  }
}