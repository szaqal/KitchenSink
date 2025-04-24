package basics.files

import scala.io.Source


object FileReader {

  def readFile() = Source.fromInputStream(getClass().getResourceAsStream("data")).getLines.toList.mkString(":")
  
}