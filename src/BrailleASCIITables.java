import java.io.File;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

import org.w3c.dom.Node;

/**
 * changes braille to ascii, ascii to braille, and braille to unicode
 *
 * @author Nye Tenerelli
 */

public class BrailleASCIITables {

  static BitTree ACtoBR;
  static BitTree BRtoAS;
  static BitTree BRtoUN;


  public BrailleASCIITables() throws Exception {
    //Making a class for each set of pairs
        ACtoBR = new BitTree(8);
        BRtoAS = new BitTree(6);
        BRtoUN = new BitTree(6);

        // ACtoBR.set("00100101", "cat");
        // ACtoBR.set("00100101", "dog");


        //Print writer to print out
        PrintWriter pen = new PrintWriter(System.out,true);


        //Creating files for each txt file
        File ACtoBRf = new File("ASCIItoBraille.txt");
        File BRtoASf = new File("BrailletoASCII.txt");
        File BRtoUNf = new File("BrailletoUnicode.txt");

        //creating scanners for each file along with calling the reader method to add it to its corresponing BitTree class
        Scanner ACtoBRs = new Scanner(ACtoBRf);
        reading(ACtoBRs, ACtoBR);
        ACtoBRs.close();
        Scanner BRtoASs = new Scanner(BRtoASf);
        reading(BRtoASs, BRtoAS);
        BRtoASs.close();
        Scanner BRtoUNs = new Scanner(BRtoUNf);
        reading(BRtoUNs, BRtoUN);
        BRtoUNs.close();
    }

    public void reading(Scanner input, BitTree tree) throws Exception{
      while (input.hasNextLine())  {
          String[] lines = input.nextLine().split(",");
          tree.set(lines[0], lines[1]);
      }
  }


    /*
    * String toBraille(char letter), which converts an ASCII character to a string of bits representing the corresponding braille character.
    */
    public static String toBraille(char letter) throws UnsupportedEncodingException  {
      String bits = "0" + Integer.toBinaryString(letter);
      return ACtoBR.get(bits);
    }

    /*
    * String toASCII(String bits), which converts a string of bits representing a braille character to the corresponding ASCII character.
    */
    public static String toASCII(String bits)  {
      System.out.println(bits);
      return BRtoAS.get(bits);
    }

    /*
    * String toUnicode(String bits), which converts a string of bits representing a braille character to the corresponding Unicode braille character for those bits.
    * You need only support six-bit braille characters.
    */
    public static String toUnicode(String bits)  {
      return  BRtoUN.get(bits);
    }

}
