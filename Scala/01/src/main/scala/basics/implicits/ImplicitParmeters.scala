package basics.implicits

object ImplicitParmeters {

  def hello(implicit arg: Dog) = arg.name
  
}