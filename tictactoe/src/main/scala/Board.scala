
class Board {

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

  //Have we won and what value?
  def winCheck(): (Boolean, Int) ={

    //Horizontal
    for(row <- 0 to 2){
      spaces(row) match{
        case Array(val1, val2, val3) =>
          if(val1 != 0 && val1 == val2 && val2 == val3) {
            return (true, val1)
          }
      }
    }

    //Vertical
    for(col <- 0 to 2){
        if( spaces(0)(col) != 0 && spaces(0)(col) == spaces(1)(col) && spaces(1)(col) == spaces(2)(col) ) {
          return (true, spaces(0)(col))
        }
    }

    //Diagonal
    //Only Two diagonal possibilities
    if(spaces(0)(0) != 0){
      if( spaces(0)(0) == spaces(1)(1) && spaces(1)(1) == spaces(2)(2) )
        return (true, spaces(0)(0))
    }

    if(spaces(0)(2) != 0){
      if( spaces(0)(2) == spaces(1)(1) && spaces(1)(1) == spaces(2)(0) )
        return (true, spaces(0)(0))
    }

    return (false, 0);

  }

  def contains(value: Int): Boolean ={
    for(row <- 0 to 2){
      if(spaces(row).contains(value)) return true
    }
    return false
  }

}
