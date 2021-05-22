

class Board {

  //TODO probably a better name for this
  var spaces = Array.ofDim[Int](3, 3);

  def init(): Unit ={
    //0 is empty space
    for(row <- 0 to 2){
      for(col <- 0 to 2){
        spaces(row)(col) = 0;
      }
    }
  }


  def isSpaceEmpty(row: Int, col: Int): Boolean ={
    if(spaces(row)(col) == 0)
      return true
    else
      return false
  }

  def updateSpace(row: Int, col: Int, newVal: Int): Unit ={

    if(newVal < 0 || newVal > 2) throw new IllegalArgumentException("New Value must be 0, 1, or 2")
    if(row < 0 || row > 2) throw new IllegalArgumentException("Row must be 0, 1, or 2")
    if(col < 0 || col > 2) throw new IllegalArgumentException("Col must be 0, 1, or 2")

    spaces(row)(col) = newVal;
    println(s"Value $newVal placed in row $row, col $col")
  }

  //Console print to visualize board
  def printBoard(): Unit ={
    for(row <- 0 to 2){
      println(s"${spaces(row)(0)}|${spaces(row)(1)}|${spaces(row)(2)}")
    }
  }

  def winCheck(): Boolean ={
    var boardState = spaces.flatten

    //TODO Store Conditions in some structure
    //TODO how can we see multi wins? IE two three in a rows in one move?
    //TODO this may need to be iterative
    boardState match {
      case Array(1, 1, 1, 0, 0, 0, 0, 0, 0) => println("Wooo baby thats what i'm talking about")
      case _ => println("No Victory Condition Met")
    }

    //TODO implement win conditions
    return false;
  }


}
