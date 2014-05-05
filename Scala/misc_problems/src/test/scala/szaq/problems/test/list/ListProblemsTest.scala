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

  //----

  test("nth1") {
    assert(ListProblems.nthElement(2, List(1, 2, 3)) === 3);
  }

  test("nth2") {
    intercept[java.util.NoSuchElementException] {
      ListProblems.nthElement(2, List[Int](1))
    }
  }

  test("nth3") {
    intercept[java.util.NoSuchElementException] {
      ListProblems.nthElement(2, List[Int](0))
    }
  }

  // ----

  test("length1") {
    assert(ListProblems.length(List(1, 2, 3)) === 3);
  }

  test("length2") {
    assert(ListProblems.length(List(1)) === 1)
  }

  test("length3") {
    assert(ListProblems.length(List()) === 0)
  }

  // ----

  test("rev1") {
    assert(ListProblems.reverse(List(1, 2, 3)) === List(3,2,1));
  }

  test("rev2") {
    assert(ListProblems.reverse(List(1)) === List(1))
  }

  test("rev3") {
    assert(ListProblems.reverse(List()) === List())
  }
}