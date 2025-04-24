package basics.enums

import org.scalatest.FunSuite

class ColorEnumTest extends FunSuite {
  
  test("EnumTest") {
    assert(ColorEnum.BLUE === ColorEnum.BLUE)
  }
}