package facebook;


class rotateString {

  // Add any helper functions you may need here
  

  String rotationalCipher(String input, int rotationFactor) {
    // Write your code here
    char[] ch = input.toCharArray();
    for(int i = 0; i < ch.length; ++i) {
      if(ch[i] >= 48 && ch[i] <= 57) {
        ch[i] = rotate (ch[i], rotationFactor%9);
      }
      else {
        ch[i] = rotate (ch[i], rotationFactor%26);
      }
    }
    return new String(ch);
  }

public char rotate(char ch, int factor) {
  if (ch >= 48 && ch <= 57) {
    int num = ch - '0' + factor;
    if (num > 9) {
      return (char) ('0' + (num - 10));
    }
    else
      return (char) ('0' + num);
  }
  else if (ch >= 65 && ch <= 90) {
    char newChar = (char) (ch - 'A' + factor);
    if (newChar > 26) {
      return (char) ('A' + (newChar - 26));
    }
    else
      return (char) ('A' + newChar);
  }
  else if (ch >= 97 && ch <= 122) {
     char newChar = (char) (ch - 'a' + factor);
    if (newChar > 26) {
      return (char) ('a' + (newChar - 26));
    }
    else {
      return (char) ('a' + newChar);
    }
  }
  else {
    return ch;
  }
 }
  
  // These are the tests we use to determine if the solution is correct.
  // You can add your own at the bottom.
  int test_case_number = 1;
  void check(String expected, String output) {
    boolean result = (expected.equals(output));
    char rightTick = '\u2713';
    char wrongTick = '\u2717';
    if (result) {
      System.out.println(rightTick + " Test #" + test_case_number);
    }
    else {
      System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
      printString(expected); 
      System.out.print(" Your output: ");
      printString(output);
      System.out.println();
    }
    test_case_number++;
  }
  void printString(String str) {
    System.out.print("[\"" + str + "\"]");
  }
  
  public void run() {
    String input_1 = "All-convoYs-9-be:Alert1.";
    int rotationFactor_1 = 4;
    String expected_1 = "Epp-gsrzsCw-3-fi:Epivx5.";
    String output_1 = rotationalCipher(input_1, rotationFactor_1);
    check(expected_1, output_1);

    String input_2 = "abcdZXYzxy-999.@";
    int rotationFactor_2 = 200;
    String expected_2 = "stuvRPQrpq-999.@";
    String output_2 = rotationalCipher(input_2, rotationFactor_2);
    check(expected_2, output_2);

    // Add your own test cases here
    
  }
  
  public static void main(String[] args) {
    new rotateString().run();
  }
}


