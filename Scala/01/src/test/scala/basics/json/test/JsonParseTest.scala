package basics.json.test

import org.scalatest.FunSuite
import basics.json.JsonParse

class JsonParseTest extends FunSuite {
  
  
  test("HolderTest") {
    assert(JsonParse.getKeys === Map("a"->"a"))
  }
}