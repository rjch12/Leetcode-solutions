class utf8Validation_393 {
public static void main(String[] args) {
  utf8Validation_393 utf = new utf8Validation_393();
  System.out.println( utf.validUtf8(new int[]{255}));
  System.out.println( utf.validUtf8(new int[]{237}));
  System.out.println( utf.validUtf8(new int[]{197,130,1}));
  System.out.println( utf.validUtf8(new int[]{235,140,4}));
} 
 public boolean validUtf8(int[] data) {
    int rbytes = 0;
    for (int val : data) {
      if (rbytes == 0) {
        if ((val >> 7) == 0) { // single byte utf starting with 0
          rbytes = 0;
        } else if ((val >> 5) == 6) { // two bytes utf starting with 110 and 2nd byte with 10
          rbytes = 1;
        } else if ((val >> 4) == 14) { // three bytes utf starting with 1110 and other bytes with 10
          rbytes = 2;
        } else if ((val >> 3) == 30) { // four bytes utf starting with 11110 and other bytes with 10
          rbytes = 3;
        }
        else return false;
      } else {
        if ((val >> 6) == 2) // other bytes start with 10 i.e 6 > right shift makes it 2.
          rbytes--;
        else
          return false;
      }
    }
    return rbytes == 0;

  }
}
