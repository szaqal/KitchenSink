package basics.patterns

object PatternMatching {

  def doMatchnigValue(value: Int): String = {
    value match {
      case 1 => "one"
      case 2 => "two"
      case _ => "unknown"
    }
  }

  def doMatchnigType(value: Any): String = {
    value match {
      case _: Int => "int"
      case _: Double => "double"
      case _: String => "string"
      case _ => "unknown"
    }
  }

  def doMatchingCaseClass(value: MatchedClass): String = {
    value match {
      case MatchedClass(1) => "1"
      case MatchedClass(2) => "2"
      case _ => "other"
    }
  }

  def doMatchingFunction(value: (String => Int)): String = {
    value match {
      case _: (String => Int) => "String to Int"
      case _ => "other"
    }
  }
  
  def doListMatch(value:List[_]): String = {
    value match {
      case List(_,0,1,_) => "Found"
      case _ => "Not found"
    }
  } 

}