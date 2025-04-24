package basics.implicits

object ImplicitSample {

  implicit def convert(arg: Dog): Cat = {
    return Cat(arg.name)
  }

  def printName(arg: Cat): String = arg.name
}
