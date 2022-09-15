import java.util.*;

class longestAbsoluteFilePath_388 {
  public static void main(String[] args) {
    longestAbsoluteFilePath_388 lafp = new longestAbsoluteFilePath_388();
    // System.out.println(lafp.lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"));
    // System.out.println(lafp.lengthLongestPath("file1.txt\nfile2.txt\nlongfile.txt"));
    System.out.println(lafp.lengthLongestPath("dir\n        file.txt"));
    System.out.println(lafp.lengthLongestPath("file1.txt\nfile2.txt\nlongfile.txt"));
  }

  public int lengthLongestPath(String input) {

    Stack<Integer> st = new Stack<>();
    st.push(0);
    // Input: input = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"
    // path: input[]= [dir, \tsubdir1, \tsubdir2, \t\tfile.ext]
    int max = 0;
    for (String s : input.split("\n")) { // s: \tfile1.ext
      int tab = s.lastIndexOf('\t') + 1; // \t : 1
      int len = s.length() - tab; // dir: 11 - 2
      while (st.size() > tab + 1)
      st.pop();

      if (s.contains(".")) {
        max = Math.max(max, st.peek() + len);
      } else {
        st.push(len + st.peek() + 1); // 12
      }
    }
    return max;
  }
}
