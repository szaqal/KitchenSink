package basics.oo

class PrivateConstructor private (val arg: String) {

  def this() = this("Default")

  def getText = arg;
}