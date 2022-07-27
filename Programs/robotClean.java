// 

// import java.util.Set;
// import java.util.HashSet;
// // import java.util.Pair;

// class Pair {
//   int a, b;
//   public Pair(int a, int b) {
//     this.a = a;
//     this.b = b;
//   }
// }
// class Robot {
//   public boolean move() {
//     return false;
//   }
//   protected void clean (){}
// }

// class robotClean {
//   public static void main(String[] args) {
    
//   }
//   /**
//  * // This is the robot's control interface.
//  * // You should not implement it, or speculate about its implementation
//  * interface Robot {
//  *     // Returns true if the cell in front is open and robot moves into the cell.
//  *     // Returns false if the cell in front is blocked and robot stays in the current cell.
//  *     public boolean move();
//  *
//  *     // Robot will stay in the same cell after calling turnLeft/turnRight.
//  *     // Each turn will be 90 degrees.
//  *     public void turnLeft();
//  *     public void turnRight();
//  *
//  *     // Clean the current cell.
//  *     public void clean();
//  * }
//  */

//   int [][] dir = { {-1, 0}, {0, 1}, {1, 0}, {0, -1}};
//   Set<Pair> visited = new HashSet<>();
//   Robot robot;
  
//   public void cleanRoom(Robot robot) {
//       this.robot = robot;
//       backtrack (0, 0, 0);
//   }
//   public void backtrack(int row, int col, int dir) {
//       visited.add(new Pair(row, col));
//       robot.clean();

//       for(int i = 0; i < 4; i++) {
//         int newRow = row + dir[i][0];
//         int newCol = col + dir[i][1];
//         backtrack(row, col, i);
//       }
      
//   }
// }
