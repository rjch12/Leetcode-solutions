

class specialTypewriter_1974 {
  public static void main(String[] args) {
    specialTypewriter_1974 st = new specialTypewriter_1974();
    System.out.println(st.minTimeToType("abc"));
  }

  public int minTimeToType(String word) {
    int counter = 0;
    char pointer = 'a';
    for(int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      counter += Math.min((pointer - c), 'z' -c);


      counter += Math.min(pointer - 'a', 'z' - pointer );
      pointer = word.charAt(i);
      counter++;
    }
    return counter + word.length();
  }
}