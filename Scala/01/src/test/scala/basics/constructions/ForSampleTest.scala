package basics.constructions

import org.scalatest.FunSuite

class ForSampleTest extends FunSuite {

  test("PartitionTest") {
    assert(ForSample.doFilter(List(1, 2, 3, 4, 5, 6, 7)) == 2)
  }

}