import colourGuess._
import org.scalatest.FunSuite

class GameBoardTest extends FunSuite {

  val gameBoardTest = new GameBoard

  test("GameBoard.getGameSizeLogic will only be a positive integer"){
    val default = 4
    assert(gameBoardTest.getGameSizeLogic("any string", default)>0)
    assert(gameBoardTest.getGameSizeLogic("-1", default)>0)
    assert(gameBoardTest.getGameSizeLogic("5", default)>0)
    assert(gameBoardTest.getGameSizeLogic("0", default)>0)
    assert(gameBoardTest.getGameSizeLogic("5.5", default)>0)
  }

  test("GameBoard.getEasinessLogic with a 'y' or 'yes' input will be true"){
    assert(gameBoardTest.getEasinessLogic("yes"))
    assert(gameBoardTest.getEasinessLogic("y"))
    assert(gameBoardTest.getEasinessLogic("Yes"))
    assert(gameBoardTest.getEasinessLogic("Y"))
  }

  test("GameBoard.newCode is a string"){
    val size = 4
    assert(gameBoardTest.newCode(size).getClass=="any string".getClass)
  }

  test("GameBoard.compareChar(x,x) is true"){
    assert(gameBoardTest.compareChar('x','x'))
  }

  test("GameBoard.compareChar(x,y) is false"){
    assert(!gameBoardTest.compareChar('x','y'))
  }
}

