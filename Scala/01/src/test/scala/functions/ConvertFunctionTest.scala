package functions

import org.scalatest.FunSuite
import basics.functions.ConvertFunction
import basics.functions.ConvertFunction

class ConvertFunctionTest extends FunSuite {

  def exec(): String = {
    val fun: Int => String = new ConvertFunction()
    fun(3)
  }
  

  test("Function test1") {
    assert(exec() == "3");
  }
  
}
