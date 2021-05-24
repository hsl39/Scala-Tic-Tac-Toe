import scala.io.StdIn

class Game {

  val board = new Board
  val players = new Array[Player](2);
  var currentPlayer = 0;
  var currentTurn = 0;

  def start(): Unit ={

    println("Starting Game")
    println("--------------")
    board.init()

    players(0) = new Player("Player 1")
    players(1) = new Player("Player 2")

    currentPlayer = 1;
    currentTurn = 1;

    runGame();

  }

  def runGame(): Unit ={

    if(currentPlayer == 0) throw new IllegalAccessError("Use the start function to begin.")

    //Game Loop
    while( !board.winCheck()._1 && board.contains(0)){

      println(s"Turn ${currentTurn}")
      board.printBoard()

      var move = getMove()
      //-1 to account for 0 indexing
      board.updateSpace(move._1 - 1, move._2 - 1, currentPlayer);

      endTurn()

    }

    if(board.winCheck()._2 != 0){
      println(s"Player ${board.winCheck()._2} wins!")
      board.printBoard()
    }
    else{
      println("No more possible moves.");
    }

  }

  def endTurn(): Unit ={
    currentPlayer = if (currentPlayer == 1) 2 else 1
    currentTurn += 1;
  }

  def getMove(): (Int, Int) = {
    var validInput = false

    //TODO consider a better way to initialize this
    var rowInput = -1;
    var colInput = -1;
    while (!validInput) {

      try{

        println("Enter row: ")
        rowInput = StdIn.readInt()
        if(rowInput > 3 || rowInput < 1) throw new IllegalArgumentException

        println("Enter column: ")
        colInput = StdIn.readInt()
        if(colInput > 3 || colInput < 1) throw new IllegalArgumentException

        if(board.isSpaceEmpty(rowInput - 1,colInput - 1)) {
          validInput = true
        }
        else {
          println("Space is not empty.")
        }

      }
      catch{
        case e: NumberFormatException => println("Invalid input.")
        case e: IllegalArgumentException => println("Input out of bounds.")
      }

    }

    return (rowInput,colInput)
  }

}

