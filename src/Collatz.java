import java.util.Scanner;
public class Collatz
{
    private static int[] tableSize = new int[100000001];
    private static int numberImLooking4;
    private static int counter;

    public static void main(String[] args)
    {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the range:");
            long one = sc.nextLong();
            long two = sc.nextLong();
            collatz(one, two);
            System.out.println("The number with the maximum Collatz length in the range: " + counter);
            System.out.println("Its Collatz length: " + numberImLooking4);
    }

    private static int collatzLength(long x)
    {
          int base = 1;
          if (x <= 100000000 && tableSize[(int) x] != 0)  return tableSize[(int) x];
          if (x == 1)   return base;
          else if (x % 2 == 0) return base + collatzLength(x/2);
          else  return base + collatzLength(3 * x + 1);
    }

     private static int wrapperFunction(long x)
    {
      int y = collatzLength(x);
      if(x < 100000000)  tableSize[(int)x] = y;
      return y;
    }

  private static void collatz(long x, long y)
    {
      long z = x;
      while(z <= y)
      {
        int minNumber = wrapperFunction(z);
        if (minNumber > numberImLooking4)
        {
            numberImLooking4 = minNumber;
            counter = (int)z;
        }
        z++;
      }
    }


}
