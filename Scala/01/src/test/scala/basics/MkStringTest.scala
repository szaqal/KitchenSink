package basics

import org.scalatest.FunSuite

class MkStringTest extends FunSuite {

  test("VarArgs test1") {
    assert(MkString.concat(List("a", "b", "c")) === "a:b:c");
  }
}