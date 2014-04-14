package basics.files

import org.scalatest.FunSuite

class FileReaderTest extends FunSuite {
  
  test("FileReadTest") {
    assert(FileReader.readFile === "a:b:c:d");
  }
}