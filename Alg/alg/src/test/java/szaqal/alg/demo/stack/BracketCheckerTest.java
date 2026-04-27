package szaqal.alg.demo.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BracketCheckerTest {

  @Test
  public void test() {
    Assertions.assertFalse(new BracketChecker("a{b(c]d}e").check());
    Assertions.assertTrue(new BracketChecker("{}").check());
  }
}
