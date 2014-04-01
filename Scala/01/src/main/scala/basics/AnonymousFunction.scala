package basics

object AnonymousFunction {
  
  val anonymous = (x: Int) => x +2;

  def add() = { (x: Int) => x + 1 }
  
  def add1(x: Int) = { add().apply(x) }
} 