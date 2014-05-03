package szaq.sorting.test

import org.scalatest.FunSuite
import szaq.sorting.MergeSort

class MergeSortTest extends FunSuite {

  test("MergeSort1") {
    assert(MergeSort.sort(List(5, 3, 8, 1)) === List(1, 3, 5, 8))
  }

  test("MergeSort2") {
    assert(MergeSort.sort(List(1, 1, 2, 1, 3)) === List(1, 1, 1, 2, 3))
  }

  test("MergeSort3") {
    assert(MergeSort.sort(List(3, 2, 1)) === List(1, 2, 3))
  }

  test("MergeSort4") {
    assert(MergeSort.sort(List(8, 7, 6, 5, 4, 3, 2, 1)) === List(1, 2, 3, 4, 5, 6, 7, 8))
  }

  test("MergeSort5") {
    assert(MergeSort.sort(List(1, 3, 2, 1, 3, 2, 1)) === List(1, 1, 1, 2, 2, 3, 3))
  }
}