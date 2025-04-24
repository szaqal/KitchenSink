package basics.spectests

import org.scalatest.FunSpec

class SpecTest extends FunSpec {

  describe("Test Spec") {
    it("should return 2") { assert(List(1,2).size == 2) }
  }
} 