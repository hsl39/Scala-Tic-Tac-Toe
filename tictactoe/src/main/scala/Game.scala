import scala.io.StdIn

class Game {

  val board = new Board
  val players = new Array[Player](2);
  var currentPlayer = 0;
  var currentTurn = 0;

  def start(): Unit ={

    println("Starting Game")
    board.init()

    players(0) = new Player("Player 1")
    players(1) = new Player("Player 2")

    currentPlayer = 1;
    currentTurn = 1;

    runGame();

  }


  def runGame(): Unit ={

    if(currentPlayer == 0) throw new IllegalAccessError("Use the start function to begin")

    while(!board.winCheck()){

      println(s"Turn ${currentTurn}")
      board.printBoard()
      println()

      var move = getMove()
      //-1 to account for 0 indexing
      board.updateSpace(move._1 - 1, move._2 - 1, currentPlayer);

      endTurn()

    }

  }

  def endTurn(): Unit ={
    currentPlayer = if (currentPlayer == 1) 2 else 1
    currentTurn += 1;
  }

  def getMove(): (Int, Int) = {
    var validInput = false
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

        validInput = true;
      }
      catch{
        case e: NumberFormatException => println("Invalid Input")
        case e: IllegalArgumentException => println("Input Out of Bounds")
      }


    }

    return (rowInput,colInput)
  }

}
