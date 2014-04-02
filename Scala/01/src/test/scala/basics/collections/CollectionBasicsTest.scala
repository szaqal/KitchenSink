package basics.collections

import org.scalatest.FunSuite

class CollectionBasicsTest extends FunSuite {

  test("ZipTest") {
    val result = CollectionBasics.doZip()(1)
    print(result)
    assert(result._1 === 2)
    assert(result._2 === ("b", "B"))
  }

  test("PartitionTest") {
    val result = CollectionBasics.doPartition
    assert(result._1 === List(4, 5, 6))
    assert(result._2 === List(1, 2, 3))
  }

  test("FilterTest") {
    val result = CollectionBasics.doFilter
    assert(result === List(1))
  }

  test("FindTest") {
    val result = CollectionBasics.doFind
    assert(result === Some(1))
  }

  test("FlattenTest") {
    val result = CollectionBasics.doFlatten
    assert(result === List(1, 2, 3, List(4, 5, 6), 7, 8, 9))
  }
  
  
}