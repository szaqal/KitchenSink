package szaqal.alg.demo.tree;

public class Node {
  Node left;
  Node right;
  int data;

  Node( int data ) {
    this.data = data;
    left = null;
    right = null;
  }

  public static Node insert(
      Node root,
      int data ) {
    if (root == null) {
      return new Node(data);
    } else {
      Node cur;
      if (data <= root.data) {
        cur = insert(root.left, data);
        root.left = cur;
      } else {
        cur = insert(root.right, data);
        root.right = cur;
      }
      return root;
    }
  }
}
