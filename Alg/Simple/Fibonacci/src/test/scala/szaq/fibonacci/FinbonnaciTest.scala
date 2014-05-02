package szaq.fibonacci

import org.scalatest.FunSuite

class FinbonnaciTest extends FunSuite {

  test("FibonnaciTest") {
    assert(Fibonacci.compute(0) === 0)
  }

  test("FibonnaciTest1") {
    assert(Fibonacci.compute(1) === 1)
  }

  test("FibonnaciTest2") {
    assert(Fibonacci.compute(2) === 1)
  }

  test("FibonnaciTest3") {
    assert(Fibonacci.compute(3) === 2)
  }

  test("FibonnaciTest4") {
    assert(Fibonacci.compute(4) === 3)
  }

  test("FibonnaciTest5") {
    assert(Fibonacci.compute(5) === 5)
  }
}