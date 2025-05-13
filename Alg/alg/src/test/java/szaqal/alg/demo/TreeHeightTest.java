package szaqal.alg.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

public class TreeHeightTest {

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
    int []vals = {3,5,2,1,4,6,7};
    Node root = null;
    for(int data : vals) {
      root = insert(root, data);
    }
    int height = TreeHeight.height(root);
    Assertions.assertEquals(3, height);
  }
}
