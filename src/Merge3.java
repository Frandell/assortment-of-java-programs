import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Merge3
{
    private static int size;
    private static int one;
    private static int two;
    private static int[] array4;

    private static void sort(int[] a, int[] b, int[] c)
    {
        for (int i = 0; i < c.length; i++)
        {
            if (one < a.length && two < b.length)
            {
                if (b[two] < a[one])
                {
                    c[i] = b[two];
                    two++;
                }
                else
                {
                    c[i] = a[one];
                    one++;
                }
            }
            else if (two < b.length)
            {
                c[i] = b[two];
                two++;
            }
            else
            {
                c[i] = a[one];
                one++;
            }
        }
    }

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        size = scan.nextInt();
        int[] array1 = new int[size];
        int[] array2 = new int[size];
        int[] array3 = new int[size];
        int[] array4 = new int[size*2];
        int[] array5 = new int[size*3];
        for (int i = 0; i < size; i++)
        {
            if (i < size)
            {
                array1[i] = scan.nextInt();
            }
        }
        for (int i = 0; i < size; i++)
        {
            if (i < size)
            {
                array2[i] = scan.nextInt();
            }
        }
        for (int i = 0; i < size; i++)
        {
            if (i < size)
            {
                array3[i] = scan.nextInt();
            }
        }
        sort(array1, array2, array4);
        one = 0;
        two = 0;
        sort(array4, array3, array5);
        for (int i = 0; i < size*3; i++)
        {
            System.out.print(array5[i] + "  ");
        }


    }
}
