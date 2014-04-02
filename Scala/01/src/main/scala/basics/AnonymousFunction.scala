package basics

object AnonymousFunction {

  val anonymous = (x: Int) => x + 2;

  def add() = { (x: Int) => x + 1 }

  def add1(x: Int) = { add().apply(x) }

  def execFun(f: Int => Int, a: Int) = f(a)

  def execFun(f: (Int, Int) => Int, a: Int, b: Int) = f(a, b)
} 