package basics.variance

class ItemHolder[T](item: T) {
  def getObject() = item
  def getItem(item: T): T = item
}