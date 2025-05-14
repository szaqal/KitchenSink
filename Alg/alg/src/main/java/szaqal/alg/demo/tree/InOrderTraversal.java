package szaqal.alg.demo.tree;

/**
 * https://www.hackerrank.com/challenges/tree-inorder-traversal/
 */
public class InOrderTraversal {
  public static void inOrder( Node root ) {
    if(root == null) {
      return;
    }
    inOrder(root.left);
    System.out.print(root.data + " ");
    inOrder(root.right);

  }

}
