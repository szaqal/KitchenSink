package szaqal.alg.demo.tree;

import org.junit.jupiter.api.Test;

public class TraversalTest {

  @Test
  public void test() {
    int[] vals = new int[]{1,2,5,3,4,6};

    Node root = null;
    for(int i : vals) {
      root = Node.insert(root, i);
    }
    Traversal.inOrder(root);
  }

  @Test
  public void test2() {
    int[] vals = new int[]{1,2,5,3,4,6};
    Node root = null;
    for(int i : vals) {
      root = Node.insert(root, i);
    }
    Traversal.postOrder(root);
  }

  @Test
  public void test3() {
    int[] vals = new int[]{1,2,5,3,4,6};
    Node root = null;
    for(int i : vals) {
      root = Node.insert(root, i);
    }
    Traversal.preOrder(root);
  }
}
