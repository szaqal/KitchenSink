package basics.implicits

import org.scalatest.FunSuite
import basics.implicits.ImplicitParameter._

class ImplicitParameterTest extends FunSuite {
  
  test("ImplicitTest1") {
    assert(ImplicitParmeters.hello === "Implicit Dog");
  }
}
