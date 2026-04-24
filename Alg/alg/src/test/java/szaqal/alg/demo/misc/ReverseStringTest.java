package szaqal.alg.demo.misc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReverseStringTest {

  @Test
  public void test() {
    assertEquals("cba", ReverseString.reverse("abc"));
    assertEquals("dcba", ReverseString.reverse("abcd"));

    assertEquals("cba", ReverseString.reverseStack("abc"));
    assertEquals("dcba", ReverseString.reverseStack("abcd"));
  }
}
