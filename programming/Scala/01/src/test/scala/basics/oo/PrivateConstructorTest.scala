package basics.oo

import org.scalatest.FunSuite

class PrivateConstructorTest extends FunSuite {

  test("PrivateConstructor") {
      assert(new PrivateConstructor().getText === "Default")
  }

}