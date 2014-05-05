package szaq.problems.test.list

import org.scalatest.FunSuite
import szaq.problems.list.ListProblems

class ListProblemsTest extends FunSuite {

  test("last1") {
    assert(ListProblems.last(List(1, 2, 3, 4)) === 4);
  }

  test("last2") {
    assert(ListProblems.last(List(1, 2)) === 2);
  }

  test("last3") {
    assert(ListProblems.last(List[Int](1)) === 1);
  }

  test("last4") {
    intercept[java.util.NoSuchElementException] {
      ListProblems.last(List[Int]())
    }
  }

  test("penultimate1") {
    assert(ListProblems.penultimate(List(1, 2, 3, 4)) === 3);
  }

  test("penultimate2") {
    assert(ListProblems.penultimate(List(1, 2)) === 1);
  }

  test("penultimate3") {
    intercept[java.util.NoSuchElementException] {
      ListProblems.penultimate(List[Int]())
    }
  }

  test("penultimate4") {
    intercept[java.util.NoSuchElementException] {
      ListProblems.penultimateRecursive(List[Int](1))
    }
  }

  test("penultimate5") {
    assert(ListProblems.penultimateRecursive(List(1, 2, 3, 4)) === 3);
  }

  test("penultimate6") {
    assert(ListProblems.penultimateRecursive(List(1, 2)) === 1);
  }

  test("penultimate7") {
    intercept[java.util.NoSuchElementException] {
      ListProblems.penultimateRecursive(List[Int]())
    }
  }

  test("penultimate8") {
    intercept[java.util.NoSuchElementException] {
      ListProblems.penultimateRecursive(List[Int](1))
    }
  }

}