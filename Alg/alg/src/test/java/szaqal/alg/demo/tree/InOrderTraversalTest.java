package szaqal.alg.demo.tree;

import org.junit.jupiter.api.Test;

public class InOrderTraversalTest {

  @Test
  public void test() {
    int[] vals = new int[]{1,2,5,3,4,6};

    Node root = null;
    for(int i : vals) {
      root = Node.insert(root, i);
    }
    InOrderTraversal.inOrder(root);
  }
}
