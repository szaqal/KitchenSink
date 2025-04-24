package basics

object PartialApplication {

  val add = (x: Int, y: Int) => x + y
  
  val addPartial = add(2, _: Int)
  
  def doAddPartial(x:Int)  = addPartial(x)
}