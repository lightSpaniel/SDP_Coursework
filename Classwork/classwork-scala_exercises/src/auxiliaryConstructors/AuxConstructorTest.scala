package auxiliaryConstructors

object AuxConstructorTest extends App{

  //Prints First constructor
  val clothes1st = new ClothesWasher()
  //Prints First constructor, then second constructor
  val clothes2nd = new ClothesWasher(modelName = "Jimmy's washer")
  //Prints First constructor, then third constructor
  val clothes3rd = new ClothesWasher(capacity = 25)


}
