

class BattleshipsinaBoard_419 {
  public static void main(String[] args) {
    BattleshipsinaBoard_419 bsiab = new BattleshipsinaBoard_419();
    System.out.println( bsiab.countBattleships(new char[][]{{'X','.','.','X'},{'.','.','.','X'},{'.','.','.','X'}}));
  }

  public int countBattleships(char[][] board) {
    int ship = 0;
    
    for(int i = 0; i< board.length; i++) {
      for(int j = 0; j < board[0].length; j++) {
        if(board[i][j] == 'X' && (i == 0 || board[i-1][j] == '.') && (j == 0 || board[i][j-1] == '.')) {
          ship++;
        }
      }
    }
    return ship;
  }
}
