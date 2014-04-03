package basics.variance

class ItemHolderCovariant[-T] {
  
  def getItem[B <: T](item: B): B = item
}
