package functions

import org.scalatest.FunSuite
import basics.functions.EchoFunction
import basics.functions.EchoFunction

class EchoFunctionTest extends FunSuite {

  def echo(name: String)(arg: String => String): String = arg.apply(name)

  def runEcho(arg: String) = {
    echo(arg) {
      new EchoFunction()
    }

  }

  test("Function test2") {
    assert(runEcho("sss")==="sss")
  }
}