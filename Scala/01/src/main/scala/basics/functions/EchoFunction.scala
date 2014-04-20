package basics.functions

class EchoFunction extends (String => String) {

  def apply(arg: String): String = arg

}