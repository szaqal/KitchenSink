package szaqal.alg.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LeftRotationTest {

  @Test
  public void test() {
    assertEquals(List.of(2,3,4,5,1), LeftRotation.rotateLeft(1, List.of(1,2,3,4,5))); ;
    assertEquals(List.of(1,2,3,4,5), LeftRotation.rotateLeft(5, List.of(1,2,3,4,5))); ;
    assertEquals(List.of(5,1,2,3,4), LeftRotation.rotateLeft(4, List.of(1,2,3,4,5))); ;
  }
}
