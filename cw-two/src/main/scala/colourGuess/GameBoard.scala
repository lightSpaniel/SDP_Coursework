package colourGuess

class GameBoard{
  //Class variables accessed throughout the class
  var gameSize = 4
  var easy = true
  var mycode = ""
  var GOES_LEFT = 12

  //Instantiation - done with method to allow easier testing
def init()={
  this.gameSize = getGameSize()
  this.easy = getEasiness()
  this.mycode = newCode(gameSize)
}

  //Default size=4. Asks user for input string
  def getGameSize():Int = {
    val DEFAULTSIZE = 4
    val userInput = scala.io.StdIn.readLine("How many pegs would you like to guess? [default "+DEFAULTSIZE+"] ")
    if(userInput != null) {
      return getGameSizeLogic(userInput, DEFAULTSIZE)
    }else{
     DEFAULTSIZE
    }
  }

  //Uses input string from getGameSize to get a strictly positive integer
  def getGameSizeLogic(input:String, defaultSize: Int):Int = {
    //Attempts to convert string to integer else returns default
    try {
      val numberPegs = input.toInt
      //If integer is less than 0 returns default
      if(numberPegs>0){
        return numberPegs
      }else{println("Defaulted to 4")}
    }catch {case e: NumberFormatException => println("Defaulted to 4")}
    defaultSize
  }

  //Requests user input for whether in easy mode - with the code displayed
  def getEasiness():Boolean={
    val userInput = scala.io.StdIn.readLine("Do you want to make this easy? ")
    getEasinessLogic(userInput)
  }
  //Logic for getEasiness split from user input for testing
  //Needs yes or y (in upper or lower case)
  def getEasinessLogic(userInput:String):Boolean={
    if((userInput.toLowerCase == "y") || (userInput.toLowerCase == "yes")){
      true
    }
    else false
  }

  //Gets new code string using the shapeFactory
  def newCode(size:Int):String={
    GetCode.shapeFactory(size)
  }

  //Gets user input and returns as string
  def getGuess(): String={
    if(easy){println(mycode)}
    val userInput = (scala.io.StdIn.readLine("What do you guess? ")).toUpperCase

    userInput
  }

  //Starts the game playing
  def play(): Unit ={
    var gotit = false
    //Keeps playing whilst "got it" is false
    while(gotit==false){

      //Changes "got it" to value of get guess
      gotit=takeTurn(getGuess())

      //If no goes left (subtracted at each get guess) you are out of goes
      if(GOES_LEFT==0){
        println("Out of goes")
        gotit=true
      }
    }
  }

  //Compares 2 characters returns true if same, else false
  def compareChar(char1: Char, char2: Char):Boolean={
    if (char1 == char2){
      true
    }else{
      false
    }
  }

  //Takes user input from get guess and returns true if code is equal
  //to secret code, else false
  def takeTurn(turn: String): Boolean={
    GOES_LEFT -=1
    var count = 0
    var letterNumber = 0
    //For each letter in string 'turn' and each char in same position in the secret code
    // passes to compareChar and increments matches count if equal
    // (& prints details of that comparison iff easy)
    for(letter <- turn) {
      printDetails(letter, mycode, easy, letterNumber)

      if (compareChar(letter, mycode.charAt(letterNumber))) {count += 1}
      letterNumber += 1
    }
    println()
    printing(count, gameSize)
    if (count == gameSize){true}else {false}
  }
  //The only point in this method is to show how the system works (if easy mode is selected)
  def printDetails(letter: Char, myCode: String,
                   easy:Boolean, letterNumber: Int):Unit={
    if(easy){
      println("LETTER: " + letter)
      println("CHECKSTRING: " + mycode.charAt(letterNumber))
    }
  }

  //Prints number of trues received from all the passes to compareChar
  def printing(black:Int, gameSize:Int): Unit ={
    for (black <- 0 until black) {
      print("BLACK ")
    }
    for (white <- 0 until (gameSize - black)) {
      print("WHITE ")
    }
    println("\n---------------------" + "\n" + GOES_LEFT + " goes left")
    if (black == gameSize) {
      println("Well done!")
    }
  }
}



