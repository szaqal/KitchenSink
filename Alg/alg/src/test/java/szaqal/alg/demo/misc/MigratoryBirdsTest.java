package szaqal.alg.demo.misc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import szaqal.alg.demo.misc.MigratoryBirds;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static szaqal.alg.demo.misc.MigratoryBirds.migratoryBirds;
import static szaqal.alg.demo.misc.MigratoryBirds.migratoryBirdsStream;

public class MigratoryBirdsTest {

  @Test
  public void test() {
    assertEquals(1, migratoryBirds(List.of(1,1,2,2,3)));
    assertEquals(1, migratoryBirdsStream(List.of(1,1,2,2,3)));
  }
}
