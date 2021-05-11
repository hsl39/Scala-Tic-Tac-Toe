

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

    //TODO implement win conditions
    return true;
  }

}
