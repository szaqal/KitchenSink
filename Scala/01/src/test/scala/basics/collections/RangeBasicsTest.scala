package basics.collections

import org.scalatest.FunSuite

class RangeBasicsTest extends FunSuite  {

    test("RangeTest1") {
    assert(RangeBasics.getRange == List(1,2,3,4,5))
    assert(RangeBasics.getRangeByTwo == List(1,3,5,7,9))
  }
}