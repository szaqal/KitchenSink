package basics.optionals

import org.scalatest.FunSuite

class OptionalSampleTest extends FunSuite {

  test("OptionalSome") {
    assert(OptionalSample.sampleSome("aaa").get === "aaa");
  }
  

  test("OptionalNone") {
    assert(OptionalSample.sampleNone("xxx").orElse(Some("zzz")).get === "zzz")
  }

  test("OptionalNone1") {
    assert(OptionalSample.sampleNone("ffff").isEmpty === true);
  }

  test("OptionalNone3") {
    assert( (OptionalSample sampleNone "ffff" orElse Some("zzz")).get === "zzz")
  }

}