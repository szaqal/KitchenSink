package basics.functions

case class ConvertFunction extends (Int => String) {

  def apply(m: Int): String = { String.valueOf(m) }
  
}