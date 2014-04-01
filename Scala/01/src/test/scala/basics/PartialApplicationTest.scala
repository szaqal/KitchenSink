package basics

import org.scalatest.FunSuite

class PartialApplicationTest extends FunSuite {

  test("PartialApplication") {
    assert(PartialApplication.addPartial(3) == 5);
  }
}