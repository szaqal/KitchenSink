package szaqal.alg.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MigratoryBirdsTest {

  @Test
  public void test() {
    Assertions.assertEquals(1, MigratoryBirds.migratoryBirds(List.of(1,1,2,2,3)));
  }
}
