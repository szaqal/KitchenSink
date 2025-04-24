package basics.implicits

import org.scalatest.FunSuite
import basics.implicits._
import basics.implicits.ImplicitSample._

class ImplicitTest extends FunSuite {
  
  
  test("ImplicitTest") {
    assert(ImplicitSample.printName(Dog("sss"))==="sss");
  }
}
