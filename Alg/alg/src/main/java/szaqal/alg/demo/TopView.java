package szaqal.alg.demo;

import java.util.ArrayList;
import java.util.List;

public class TopView {


  //TODO: 
  static List<Integer> left = new ArrayList<>();
  static List<Integer> right = new ArrayList<>();

  public static void topView( Node root ) {
    System.out.println();

    if(root.left != null) {
      left.add(root.left.data);
      topView(root.left);
    }

    if(root.right != null) {
      right.add(root.right.data);
      topView(root.right);
    }
  }

}
