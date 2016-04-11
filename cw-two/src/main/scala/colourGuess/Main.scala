package colourGuess

object Main  {
  //interface
  def main(args: Array[String]): Unit ={
    val playGame = new GameBoard
    //Need to instantiate before playing (to make testing easier)
    playGame.init()
    playGame.play()
  }
}

