import colourGuess._
import org.scalatest.FunSuite

class GetCodeTest extends FunSuite {

  test("GetCode.shapeFactory is string"){
    assert(GetCode.shapeFactory().getClass=="any string".getClass)
  }
  val input = 5
  test("GetCode.shapeFactory has length equal to input"){
    assert(GetCode.shapeFactory(input).length == input)
  }


}

