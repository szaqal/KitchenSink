package basics.lazyeval

import org.scalatest.FunSuite

class LazyEvaluationTest extends FunSuite {

  test("HolderTest") {
    assert(LazyEvaluation.doStuff == 6);
  }  
}