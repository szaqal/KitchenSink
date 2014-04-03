package basics.generics

case class HolderContainer[A <: Holder[B], B <: Any](item: Holder[B]) {

}