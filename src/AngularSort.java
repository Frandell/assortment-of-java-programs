import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Random;
public class AngularSort
{
    public Point myArray[];
    public static void main(String[] args)
    {
            Scanner scan = new Scanner(System.in);
            int b = scan.nextInt();
            Point[] myArray = new Point[b];
            for (int i = 0; i < b; i++)
            {
                double xAxis = scan.nextDouble();
                double yAxis = scan.nextDouble();
                myArray[i] = new Point(xAxis,yAxis);
            }
            AngularSort sorter = new AngularSort();
            sorter.sort(myArray);
            for (int i = 0; i < b; i++) System.out.println(myArray[i].getxPoint() + "   " + myArray[i].getyPoint());

    }

    public void sort(Point[] otherArray)
    {
        if (otherArray == null || otherArray.length == 0)  return;
        this.myArray = otherArray;
        int length = otherArray.length;
        quickSort(0, length - 1);
    }

    public void swap(int i, int j)
    {
        Point temp = myArray[i];
        myArray[i] = myArray[j];
        myArray[j] = temp;
    }

    public void quickSort(int start, int end)
    {
        Random ran = new Random();
        int i = start;
        int j = end;
        Point pivot = myArray[start + ran.nextInt(end - start + 1)];
        while (i <= j)
        {
            while (myArray[i] != null && pivot != null && myArray[i].compareTo(pivot) == -1) i++;
            while (myArray[j] != null && pivot != null && myArray[j].compareTo(pivot) == 1) j--;
            if (i <= j)
            {
                swap(i, j);
                i++;
                j--;
            }
        }
        if (start < j) quickSort(start, j);
        if (end > i) quickSort(i, end);
    }
}
