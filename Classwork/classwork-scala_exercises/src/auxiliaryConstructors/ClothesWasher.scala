package auxiliaryConstructors


class ClothesWasher {
  println("First constructor")

  def this(modelName: String){
    this
    println("Second constructor")
  }

  def this(capacity: Double){
    this
    println("third constructor")
  }

}

class ClothesWasher2(modelName: String="Default Model",
                     capacity: Double=0) {

}
