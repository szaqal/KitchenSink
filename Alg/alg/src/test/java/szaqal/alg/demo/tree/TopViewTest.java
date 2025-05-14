package szaqal.alg.demo.tree;

import org.junit.jupiter.api.Test;

public class TopViewTest {
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

  @Test
  public void test() {
    // { 1,2,5,3,4,6};
    int[] vals =  {47,2, 40, 20, 38, 30, 14, 28, 10, 16, 19, 44, 39, 27, 7, 9, 31, 12, 43, 21, 5, 41, 34, 49, 13, 33, 3, 4, 25, 22, 29, 15, 32, 35, 6 ,24, 23, 26, 1, 11, 42, 36, 37, 17, 18, 8 ,45, 48, 50, 46};
    //expected 3 5 7 10 1 2 47 49 50 46 37
    Node root = null;
    for (int data : vals) {
      root = insert(root, data);
    }
    TopView.topView(root);



  }
}
