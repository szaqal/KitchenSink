package szaq.convert

object DogService {

  def getDogName(implicit arg: Dog) = arg.name
}