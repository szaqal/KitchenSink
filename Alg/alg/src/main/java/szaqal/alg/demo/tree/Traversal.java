package szaqal.alg.demo.tree;

/**
 * <ol>
 *   <li>https://www.hackerrank.com/challenges/tree-inorder-traversal/</li>
 *   <li>https://www.hackerrank.com/challenges/tree-postorder-traversal</li>
 *   <li>https://www.hackerrank.com/challenges/tree-preorder-traversal</li>
 * </ol>
 */
public class Traversal {
  public static void inOrder( Node root ) {
    if (root == null) {
      return;
    }
    inOrder(root.left);
    System.out.print(root.data + " ");
    inOrder(root.right);

  }

  public static void postOrder( Node root ) {
    if (root == null) {
      return;
    }
    postOrder(root.left);
    postOrder(root.right);
    System.out.print(root.data + " ");
  }

  public static void preOrder(Node root) {
    if (root == null) {
      return;
    }
    System.out.print(root.data + " ");
    preOrder(root.left);
    preOrder(root.right);

  }

}
