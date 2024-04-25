import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * This class allows you to make and alter a tree of nodes
 *
 * @author Nye Tenerelli
 */

public class BitTree<K,V> {

  BitTreeNode<K,V> root;

  int length;

  BitTree(int n) {
    root = new BitTreeNode<K, V>(null, null);
    length = n;
  }

  /*
  * A method, String get(String bits), that follows the path through the tree given by bits, returning the value at the end.
  * If there is no such path, or if bits is the incorrect length, get should throw an exception
  */
  public String get(String bits)  {
    BitTreeNode node = root;
    for (int i = 0; i < bits.length(); i++) {
      if (bits.charAt(i)== ('0'))  {
        node = node.left;
      } else {
        node = node.right;
      }
    }
    return (String) node.value;
  }
  
  public void set(String bits, String value) throws Exception  {
    if (length != bits.length()) {
      System.out.println(bits + "  " + length);
      throw new Exception("ME BOMMMBOCLAAAAAAAAAAAAAAAAAAAAAAAAAAT:<===========>");
    }
    BitTreeNode node = this.root;
    for (int i = 0; i < bits.length(); i++) {
      if (bits.charAt(i)== ('0'))  {
        if (node.left == null){
          node.left = new BitTreeNode<K, V>(null, null);
        }

        node = node.left;
      } else {
        if (node.right == null){
          node.right = new BitTreeNode<K, V>(null, null);
        }
        node = node.right;
      }
    }
    node.value = (V) value;
  }

  /*
  * A method, void dump(PrintWriter pen), that prints out the contents of the tree in CSV format.
  * For example, one row of our braille tree will be “101100,M” (without the quotation marks).
  */
  public void dump(PrintWriter pen)  {
    dumper(pen, this.root, "");
  }

  public void dumper(PrintWriter pen, BitTreeNode n, String num)  {
    if (n.left == null && n.right == null){
      pen.println(num + " " + n.value);
    } else {
      if(n.left != null) {
        dumper(pen, n.left, num+"0");
      }
      if(n.right != null) {
        dumper(pen, n.right, num+"1");
      }
    }
  }
  /*
  * A method, void load(InputStream source), that reads a series of lines of the form bits,value and stores them in the tree.
  */
  public void load(InputStream source) throws Exception  {
    String s;

    try
    {
    String line;
    BufferedReader bufferedReader = new BufferedReader( new InputStreamReader( source ) );
    while( (line = bufferedReader.readLine()) != null )
    { 
      String[] lines = line.split(",");
      set(lines[0], lines[1]);
    }  
    } 
    catch( IOException e )
    {
      System.err.println( "Error: " + e );
    }

    // while (!(s = (String)source.read()).equals("-1")) {
    // while (source.read() >= 0) {
    // source.readLine());
  }

}
