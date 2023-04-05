import java.util.Scanner;

public class RunMatrix {

  // providing colors to text, I like red better
  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_RED = "\u001B[31m";

  //prints the matrix highlighting specified diagonal
  public static void printMatrix(int[][] matrix) {
    System.out.println();
    for (int row = 0; row < matrix.length; row++) {
      for (int col = 0; col < matrix[row].length; col++) {
        int size = matrix.length - 1;
        if(row + col == size) {
          System.out.print(ANSI_RED + matrix[row][col] + "\t" + ANSI_RESET);
        }
        else {
          System.out.print(matrix[row][col] + "\t");
        }
      }
      System.out.println();
    }
  }

  //populates the matrix with increasing integer values from 1 to size x size
  public static void populateMatrix(int[][] matrix) {
    System.out.println("Populating matrix....matrix poulated");
    for (int row = 0; row < matrix.length; row++) {
        for (int col = 0; col < matrix[row].length; col++) {
          matrix[row][col] = (row * matrix.length) + col + 1;
        }
      }
  }

  //flips the matrix
  public static void flipMatrix(int[][] matrix) {
    System.out.println("Flipping matrix....matrix flipped");
    //variables used to measure parameters of the matrix
    //all the same value, different names to help organize code
    int size = matrix.length;
    int length = matrix.length;
    int height = matrix.length;

    //flipping the matrix for even
    if(size % 2 == 0) {
      for (int row = 0; row < length / 2; row++) {
        for (int col = 0; col < height; col++) {
          if(row + col != size - 1) {
            int oppRow = size - row - 1;
            int oppCol = size - col - 1;
            int dummyVar = matrix[row][col];
            matrix[row][col] = matrix[oppRow][oppCol];
            matrix[oppRow][oppCol] = dummyVar;
          }
        }
      }
    }


    //flipping odd matrix
    if(size % 2 == 1){
      for (int row = 0; row < length / 2 + 1; row++) {
        if(row == height / 2) { //swapping for the middle row
          for (int col = 0; col < height / 2; col++) {
            if(row + col != size - 1) {
              int oppRow = size - row - 1;
              int oppCol = size - col - 1;
              int dummyVar = matrix[row][col];
              matrix[row][col] = matrix[oppRow][oppCol];
              matrix[oppRow][oppCol] = dummyVar;
            }
          }
        }
        else { //swapping for the other rows
          for (int col = 0; col < height; col++) {
            if(row + col != size - 1) {
              int oppRow = size - row - 1;
              int oppCol = size - col - 1;
              int dummyVar = matrix[row][col];
              matrix[row][col] = matrix[oppRow][oppCol];
              matrix[oppRow][oppCol] = dummyVar;
            }
          }
        }
      }
    }

  }

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("Please enter the size of your Matrix: ");
    int size = input.nextInt();
    int[][] matrix = new int[size][size]; //creates matrix with default values

    System.out.printf("Your matrix is %d x %d", size, size);

    printMatrix(matrix);

    populateMatrix(matrix);

    printMatrix(matrix);

    flipMatrix(matrix);

    printMatrix(matrix);

    input.close();
  }
}
