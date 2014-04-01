package basics.collections

object CollectionBasics {

  def doZip() = List(1, 2, 3).zip(List("a", "b", "c").zip(List("A", "B", "C")))

  def doPartition() = List(1, 2, 3, 4, 5, 6).partition(_ > 3)

  def doPartition2() = List(1, 2, 3, 4, 5, 6).partition((x: Int) => x > 3)

  def doFilter() = List(1, 2, 3, 4, 5, 6).filter(_ < 2);
  
  def doFind() = List(1, 2, 3, 4, 5, 6).find(_ < 2);
  
  def doFlatten() = List(List(1,2,3,List(4,5,6)), List(7,8,9)).flatten
}