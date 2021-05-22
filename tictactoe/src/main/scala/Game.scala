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

    currentPlayer = 0;
    currentTurn = 1;

  }


  def runGame(): Unit ={
    var tempTurnCount = 5;
    while(tempTurnCount > 0){

      endTurn();
      tempTurnCount -= 1
    }
    /*
    while(!board.winCheck()){

    }
    */
  }

  def endTurn(): Unit ={
    if (currentPlayer == 1) 0 else 1
    currentTurn += 1;
  }

}
