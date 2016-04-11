package parameterizedTypes

import atomic.AtomicTest._

class paramTypes {

  // Return type is inferred:
  def inferred(c1: Char, c2: Char, c3: Char) = {
    Vector(c1, c2, c3)
  }

  // Explicit return type:
  def explicit(c1: Char, c2: Char, c3: Char):
  Vector[Char] = {
    Vector(c1, c2, c3)
  }

  def explicitDouble(first: Double, second: Double, third: Double): Vector[Double] ={
    val vec = Vector(first, second, third)
    return vec
  }

  def explicitList(vec: Vector[Number]): List[Number]={

    val result = vec.toList
    return result
  }

  def explicitSet(vec: Vector[Number]): Set[Number]={
    val result = vec.toSet
    return result
  }

  def str(vec: Vector[Number]): String = {

    var result = ""
    for(num<-vec){
      result += num
      result += ","
    }
    return result
  }

}





object paramTypesTest extends App{

  val pt = new paramTypes

  pt.inferred('a', 'b', 'c') is "Vector(a, b, c)"
  pt.explicit('a', 'b', 'c') is "Vector(a, b, c)"
  pt.explicitDouble(1.0, 2.0, 3.0) is Vector(1.0, 2.0, 3.0)
  pt.explicitList(Vector(10.0, 20.0)) is List(10.0, 20.0)
  pt.explicitList(Vector(1, 2, 3)) is List(1.0, 2.0, 3.0)
  pt.explicitSet(Vector(10.0, 20.0, 10.0)) is Set(10.0, 20.0)
  pt.explicitSet(Vector(1, 2, 3, 2, 3, 4)) is Set(1.0, 2.0, 3.0, 4.0)

  //Functions as values questions
  pt.str(Vector(1,2,3,4)) is "1,2,3,4,"

  val dogYears = (years: Int) => years * 7
  dogYears(10) is 70

  var s = ""
  val v = Vector(1, 5, 7, 8)
  v.foreach(s+=dogYears(_)+" ")
  s is "7 35 49 56 "

  var t = ""
  val numbers = Vector(1, 2, 5, 3, 7)
  val squareNum = (x: Int) => x * x
  numbers.foreach(t+=squareNum(_) + " ")
  t is "1 4 25 9 49 "
}
