package szaq.sorting.test

import org.scalatest.FunSuite
import szaq.sorting.BubbleSort

class BubbleSortTest extends FunSuite {

  test("BubbleSort1") {
    assert(BubbleSort.sortIterative(Array(6, 5, 3, 1, 8, 7, 2, 4)) === Array(1, 2, 3, 4, 5, 6, 7, 8))
  }

  test("BubbleSort2") {
    assert(BubbleSort.sortIterative(Array(1, 2, 3, 4)) === Array(1, 2, 3, 4))
  }

  test("BubbleSort3") {
    assert(BubbleSort.sortIterative(Array(1, 2, 3, 2)) === Array(1, 2, 2, 3))
  }

  test("BubbleSort4") {
    assert(BubbleSort.sortRecursive(List(1, 2, 3)) === List(1, 2, 3))
  }

  test("BubbleSort5") {
    assert(BubbleSort.sortRecursive(List(2, 1, 3)) === List(1, 2, 3))
  }

  test("BubbleSort6") {
    assert(BubbleSort.sortRecursive(List(2, 1, 3, 3)) === List(1, 2, 3, 3))
  }

  test("BubbleSort7") {
    assert(BubbleSort.sortRecursive(List(8, 7, 6, 5, 4, 3, 2, 1)) === List(1, 2, 3, 4, 5, 6, 7, 8))
  }

  test("BubbleSort8") {
    assert(BubbleSort.sortRecursive(List(10, 4, 2, 3, 6)) === List(2, 3, 4, 6, 10))
  }

  test("BubbleSort9") {
    assert(BubbleSort.sortRecursiveAsc(List(10, 4, 2, 3, 6)) === List(2, 3, 4, 6, 10))
  }

  test("BubbleSort10") {
    assert(BubbleSort.sortRecursiveDesc(List(10, 4, 2, 3, 6)) === List(10, 6, 4, 3, 2))
  }
}