class Game {

  val board = new Board
  val players = new Array[Player](2);

  def start(): Unit ={

    println("Starting Game")
    board.init()

    players(0) = new Player("Player 1")
    players(1) = new Player("Player 2")

    var currentPlayer = 0;

    while(!board.winCheck()){

    }


  }


}