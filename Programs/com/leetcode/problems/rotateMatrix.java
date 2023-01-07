package com.leetcode.problems;

public class rotateMatrix {
    public static void main(String[] args) {
    int [][] matrix = new int [][]{{1,2,3},{4,5,6},{7,8,9}};
    
    rotateMatrix rw = new rotateMatrix();
    rw.display(matrix);
    rw.rotate(matrix);
    System.out.println(matrix);
    rw.display(matrix);
  } 
  public void rotate(int[][] matrix) {
    int n = matrix.length;
    if(n == 1) {
        return;
    }
    int a = 0;
    
    for(int i = 0; i < matrix.length; i++){
      for(int j = i+1; j < matrix[0].length; j++){
        a = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = a;
      }
    }
    System.out.println();
    display(matrix);
    for(int [] row: matrix){
      int i = 0, j = row.length - 1;
      int temp = 0;
      while(i < j){
        temp = row[i];
        row[i] = row[j];
        row[j] = temp;
        i++;
        j--;
      }
    } 
  }
  public void display(int [][] mat){
    for(int i = 0; i< mat.length; ++i){
      for(int j = 0; j < mat[0].length; ++j){
        System.out.print(mat[i][j]+ " ");
      } 
      System.out.println(); 
    }
  }
}
