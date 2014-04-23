package implicit_conversion

import org.scalatest.FunSuite
import szaq.convert.DogService
import szaq.convert.Cat
import szaq.convert.ImplicitConverter._

class ImplicitConvertionTest extends FunSuite {

  test("ImplicitTest") {
    assert(DogService.getDogName(Cat("I'm Cat")) === "I'm Cat");
  }
}