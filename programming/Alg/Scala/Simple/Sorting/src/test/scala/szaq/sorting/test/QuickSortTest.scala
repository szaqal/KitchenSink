package szaq.sorting.test

import szaq.sorting.QuickSort
import org.scalatest.FunSuite

class QuickSortTest extends FunSuite {

  test("QuickSort1") {
    assert(QuickSort.sort(List(5, 3, 8, 1)) === List(1, 3, 5, 8))
  }

  test("QuickSort2") {
    assert(QuickSort.sort(List(1, 1, 2, 1)) === List(1, 1, 1, 2))
  }

  test("QuickSort3") {
    assert(QuickSort.sort(List(3, 2, 1)) === List(1, 2, 3))
  }
}