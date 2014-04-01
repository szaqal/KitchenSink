package functions

import org.scalatest.FunSuite
import basics.functions.ConvertFunction
import basics.functions.ConvertFunction

class InrementFunctionTest extends FunSuite {

  def exec(): String = {
    val fun: Int => String = ConvertFunction()
    fun(3)
  }

  test("Function test1") {
    assert(exec() == "3");
  }
}
