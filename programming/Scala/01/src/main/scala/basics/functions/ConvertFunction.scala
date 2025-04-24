package basics.functions

class ConvertFunction extends (Int => String) {

  def apply(m: Int): String = { String.valueOf(m) }
  
}