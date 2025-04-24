package basics.extractors.test

import org.scalatest.FunSuite
import basics.extractors.NumberExtractor

class NumberExtractorTest extends FunSuite {

  test("ExtractorTest") {
    val extractor = NumberExtractor(20)
    val result = extractor match {
      case 20 => "20"
      case _ => "other"
    }
    assert(result === "20")
  }

}