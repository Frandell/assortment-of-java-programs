import java.util.Scanner;
import java.io.*;
import java.lang.*;

/*
 * This class implements a spell checker application.
 * This class requires a proper implementation to the StirngSet class.
 */
public class SpellChecker {

  public static void main(String [] args) {
    StringSet A = new StringSet();
    StringSet B = new StringSet();

    File f = new File("dictionary");

    try {
      Scanner sk = new Scanner(f);

      StringSet x = new StringSet();
      while (sk.hasNext())
      {
        String word = sk.next();
        x.insert(word);
      }
    //  x.print();
      System.out.println("Dicitonary loaded...");

      sk = new Scanner(System.in);

      while (sk.hasNext())
      {
        String word = sk.next();
        //A.insert(word);
        if (x.find(word))
	       System.out.println(word + " is correct.");  //x.print(); //
        else
        {
	         System.out.println("Suggesting alternatives ...");

          StringBuffer str = new StringBuffer(word);
          char c = 'a';
          int i = 0;
          int length = word.length();
          char OG = 'a';
          char replace = 'a';


              while(c <= 'z')
              {
                str.setCharAt(i, c);
                if(x.find(str.toString()) == true)
                {
                  B.insert(str.toString());
                }
                c++;

                if(c > 122 && i < length -1)
                {
                  i++;
                  c = 'a';
                  str.replace(0,word.length(), word);;
                }
              }

          B.print();
          //x.print();

          B = null;
          B =  new StringSet();
		}
      }


    } catch (FileNotFoundException e) {
      System.out.println("Cannot open file " + f.getAbsolutePath());
      System.out.println(e);
    }

  }

}
