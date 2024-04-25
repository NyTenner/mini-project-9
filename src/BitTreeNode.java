/**
 * Nodes in a binary search tree.
 *  class allows you to make and alter a tree of nodes
 *
 * @author Nye Tenerelli
 */

class BitTreeNode<K,V> {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The key.  May not be null.
   */
  K key;

  /**
   * The associated value.
   */
  V value;

  /**
   * The left subtree.
   */
  BitTreeNode<K,V> left;

  /**
   * The right subtree.
   */
  BitTreeNode<K,V> right;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a new node.
   */
  public BitTreeNode(K key, V value) {
    this.key = key;
    this.value = value;
    this.left = null;
    this.right = null;
  } // BSTNode(K,V)

} // class BSTNode<K,V>
