package szaq.convert

object ImplicitConverter {

  implicit def convert(arg: Cat): Dog = {
    return Dog(arg.name)
  }

}