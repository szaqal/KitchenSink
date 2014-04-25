package basics

object Currying {
  
  def add(x: Int)(y: Int):Int = x + y

  def add1(x: Int):Int = add(5)(x);
  
  def add2 = add(5) _;
  
  
  def addMultiple(x:Int)(y:Int)(z:Int):Int = x+y+z
  
  def addMultiple1 = addMultiple(4)(4) _
}
