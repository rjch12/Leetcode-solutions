
/* You are asked to design a file system which provides two functions:

 * createPath(path, value): Creates a new path and associates a value to it if possible and returns True. 
 * Returns False if the path already exists or its parent path doesn't exist.
 * 
 * get(path): Returns the value associated with a path or returns -1 if the path doesn't exist.
 * The format of a path is one or more concatenated strings of the form: / followed by one or more lowercase 
 * English letters. For example, /leetcode and /leetcode/problems are valid paths while an empty
 * string and / are not.

 * Input:
 * ["FileSystem","createPath","createPath","get","createPath","get"]
 * [[],["/leet",1],["/leet/code",2],["/leet/code"],["/c/d",1],["/c"]]
 * 
 * Output:
 * [null,true,true,2,false,-1]
 * Explanation:
 * FileSystem fileSystem = new FileSystem();
 * 
 * fileSystem.createPath("/leet", 1); // return true
 * fileSystem.createPath("/leet/code", 2); // return true
 * fileSystem.get("/leet/code"); // return 2
 * fileSystem.createPath("/c/d", 1); // return false because the parent path "/c" doesn't exist.
 * fileSystem.get("/c"); // return -1 because this path doesn't exist.
 */
import java.util.*;

class keyPath {
  Map<String, keyPath> children;
  String name;
  int val;

  public keyPath(String name, int v) {
    this.children = new HashMap<>();
    this.name = name;
    this.val = v;
  }
}

class designFileSystem_1166 {
  static keyPath root;

  public static void main(String[] args) {

    designFileSystem_1166 dfs = new designFileSystem_1166();

    // root - { * , -1, [] }
    root = new keyPath("*", -1);

    System.out.println(dfs.createPath("/leet", 1)); // return true
    System.out.println(dfs.createPath("/leet/code", 2)); // return true
    System.out.println(dfs.get("/leet/code")); // return 2
    System.out.println(dfs.createPath("/c/d", 1)); // return false because the parent path "/c" doesn't exist.
    System.out.println(dfs.get("/c")); // return -1 because this path doesn't exist.
  }

  public int get(String path) {
    
    keyPath crawler = root;
    String[] dirs = path.split("/");

    // /leet dirs ["", "leet"]
    // /leet dirs ["", "leet", "code"]

    for (int i = 1; i < dirs.length - 1; i++) {
      String currDir = dirs[i];

      if (crawler.children.containsKey(currDir)) {
        crawler = crawler.children.get(currDir);
      } else {
        return -1;
      }
    }
    if (crawler.children.containsKey(dirs[dirs.length - 1]))
      return crawler.children.get(dirs[dirs.length - 1]).val;
    else
      return -1;
  }

  public boolean createPath(String path, int val) {

    keyPath crawler = root;
    String[] dirs = path.split("/");

    // /leet dirs ["", "leet"]
    // /leet dirs ["", "leet", "code"]

    for (int i = 1; i < dirs.length - 1; i++) {
      String currDir = dirs[i];

      if (crawler.children.containsKey(currDir)) {
        crawler = crawler.children.get(currDir);
      } else {
        return false;
      }
    }
    crawler.children.put(dirs[dirs.length - 1], new keyPath(dirs[dirs.length - 1], val));
    return true;
  }
}
