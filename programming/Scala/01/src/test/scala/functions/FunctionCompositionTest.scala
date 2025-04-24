package functions

import org.scalatest.FunSuite
import basics.functions.FunctionComposition

class FunctionCompositionTest extends FunSuite {

  test("FunctionCompositionTest1") {
    assert(FunctionComposition.computeComposed===12);
    assert(FunctionComposition.computeComposed2===12);
  }

}