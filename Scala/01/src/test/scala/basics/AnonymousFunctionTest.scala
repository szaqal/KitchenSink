package basics

import org.scalatest.FunSuite

class AnonymousFunctionTest extends FunSuite {

  test("Anonymous function test") {
    assert(AnonymousFunction.add()(10) == 11);
  }

  test("Anonymous function test1") {
    assert(AnonymousFunction.add1(30) == 31);
  }

  test("Anonymous function test2") {
    assert(AnonymousFunction.anonymous.apply(40) == 42);
  }
}