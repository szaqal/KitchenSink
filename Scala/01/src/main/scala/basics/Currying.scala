package basics

object Currying {
  
  def add(x: Int)(y: Int):Int = x + y

  def add1(x: Int):Int = add(5)(x);
  
  def add2 = add(5) _;
  
}