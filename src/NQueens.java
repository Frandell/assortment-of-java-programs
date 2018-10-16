import java.util.Scanner;
public class NQueens
{
  private static int board[][];
  private static int size;
  private static int counter;

  public static void main(String [] args)
  {
      Scanner kb = new Scanner(System.in);
      System.out.println("Enter the number of queens: ");
      size = kb.nextInt();
      board = new int[size][size];
      recursion(board,0);
      System.out.println("The number of valid arrangements is " + counter);

  }

  private static boolean checkPossibleMove(int board[][], int row, int col)
  {
    int i;
    int j;
    for( i = 0; i < col; i++)  if(board[row][i] == 1)  return false;
    for (i = row, j = col; j >= 0 && i >= 0; j--,i--)  if(board[i][j] == 1) return false;
    for(i = row, j = col; j >= 0 && i < size; j--, i++) if(board[i][j] == 1) return false;
    return true;
  }
  private static boolean recursion(int board[][] , int x)
  {
    int i = 0;
    if (x == size)
    {
      counter++;
      return true;
    }
    while(i < size)
    {
      if(checkPossibleMove(board,i,x))
      {
        board[i][x] = 1;
        recursion(board, x+1);
        board[i][x] = 0;
      }
       i++;
    }
    return false;
  }

}
