import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Class with main takes in input and outputs the altered code
 *
 * @author Nye Tenerelli
 */

public class BrailleASCII {
    

    public static void main(String[] args) throws Exception {
        BrailleASCIITables bob = new BrailleASCIITables();

        //if braille then convert ascii to braille
        if (args[0].equals("braille")){

            String string = "";
            for (int i = 0; i < args[1].length(); i++)  {
                string += bob.toBraille(args[1].charAt(i));
            }
            System.out.println(string);
            //if ascii then convert braille to ascii
        } else if (args[0].equals("ascii")){

            if (args[1].length() % 6 != 0) {
                System.out.println("YOU BOMBO DID THE WRONG NUMBER OF CHARACTERS CLATTTTTT");
            }
            String string = "";
            for (int i = 0; i < args[1].length(); i=i+6)  {
                string += bob.toASCII(args[1].substring(i, i+6));
            }
            System.out.println(string);
         //if unicode then convert ascii to braille to unicode
        } else if (args[0].equals("unicode")){

            String string = "";
            for (int i = 0; i < args[1].length(); i++)  {
                string += bob.toBraille(args[1].charAt(i));
            }
            // String finall = "";
            int braille = 0;
            String finall = "";
            for (int i = 0; i < string.length(); i=i+6)  {
                // System.out.println(bob.toUnicode(string.substring(i, i+6)));
                braille = Integer.decode("0x" + bob.toUnicode(string.substring(i, i+6)));
                finall += (char)braille;
                // finall += bob.toUnicode(string.substring(i, i+6));
            }
            System.out.println(finall);

        } else {
            System.out.println("YOU BOMBO ENTERED BAD INPUT CLATTTTTT");
        }
    }

    
}
