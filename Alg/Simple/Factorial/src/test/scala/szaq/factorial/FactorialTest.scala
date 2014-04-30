package szaq.factorial

import org.scalatest.FunSuite

class FactorialTest extends FunSuite {

  test("FactorialTest") {
    assert(Factorial.compute(0) === 1)
  }

  test("FactorialTest1") {
    assert(Factorial.compute(1) === 1)
  }

  test("FactorialTest2") {
    assert(Factorial.compute(4) === 24)
  }
  
    test("FactorialTest3") {
    assert(Factorial.compute(12) === 479001600)
  }
}