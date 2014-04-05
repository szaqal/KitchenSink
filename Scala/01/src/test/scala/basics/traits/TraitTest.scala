package basics.traits

import org.scalatest.FunSuite

class TraitTest extends FunSuite {

  test("Trait Test") {
    assert(MainObject.method == "Hi This is helper method")
  }

}