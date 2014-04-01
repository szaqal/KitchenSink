package basics

import org.scalatest.FunSuite

class CurryingTest extends FunSuite {

  test("Currying test1") {
    assert(Currying.add(6)(6) == 12);
  }

  test("Currying test2") {
    assert(Currying.add1(7) == 12);
  }

  test("Currying test3") {
    assert(Currying.add2(3) == 8);
  }

}