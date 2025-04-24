package basics

import org.scalatest.FunSuite

class VarArgsTest extends FunSuite {

  test("VarArgs test1") {
    assert(VarArgs.add(5, 5, 5) == 15);
  }

}