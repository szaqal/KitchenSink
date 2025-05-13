package szaqal.alg.demo;

class Node {
  Node left;
  Node right;
  int data;

  Node( int data ) {
    this.data = data;
    left = null;
    right = null;
  }
}

//https://www.hackerrank.com/challenges/tree-height-of-a-binary-tree/
public class TreeHeight {

  static int level = 0;
  static int maxLevel = 0;

  public static int height( Node root ) {
    level++;
    if (level > maxLevel) {
      maxLevel = level;
    }
    //System.out.println(" ".repeat(level) + " "+root.data);
    if (root.left != null) {
      height(root.left);
      level--;
    }
    if (root.right != null) {
      height(root.right);
      level--;
    }
    return maxLevel - 1;
  }

}
