package basics.oo

import org.scalatest.FunSuite
import org.scalatest.FunSpec

class RequireParamTest extends FunSuite {

  test("RequireTest") {
    intercept[java.lang.IllegalArgumentException] {
      RequireParam.xxxxx(null)
    }
  }
}