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
  
  
  //Invalid fix later
  def doMatchingFunction(value: (Any=>Any)) : String =  {
    value match {
      case _:(String=>String) => "String to String"
      case _:(Int=>String) => "Int to String"
      case _ => "other"
    }
  }
}