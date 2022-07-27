package facebook;;

class addStrings {
  
  public static void main(String[] args) {
    addStrings as = new addStrings();
    System.out.println(as.addString("123456789","987654321"));
  }

  public String addString(String num1, String num2) {
      int len1 = num1.length() - 1, len2 = num2.length() - 1;
      
      int sum = 0, carry = 0;
      String ans = "";
      while(len1 >= 0 && len2 >= 0) {
          int dig1 = num1.charAt(len1--) - '0';
          int dig2 = num2.charAt(len2--) - '0';
          sum = dig1 + dig2 + carry;
          carry = 0;
          if(sum >= 10) {
              sum = sum%10;
              carry = 1;
          }
          ans = "" + sum + ans;
      }
      while(len1 >= 0) {
          int dig1 = num1.charAt(len1--) - '0';
          sum = dig1 + carry;
          carry = 0;
          if(sum > 10) {
              sum = sum%10;
              carry = 1;
          }
          ans = "" + sum + ans;
      }
      while(len2 >= 0) {
          int dig2 = num2.charAt(len2--) - '0';
          sum = dig2 + carry;
          carry = 0;
          if(sum > 10) {
              sum = sum%10;
              carry = 1;
          }
          ans = "" + sum + ans;


      }

      if(carry > 0) {
          ans = "" + carry + ans;
      }
      return ans;
  }
}