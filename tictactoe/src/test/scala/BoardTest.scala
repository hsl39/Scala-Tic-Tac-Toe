import org.scalatest._
import freespec._

class BoardTest extends AnyFreeSpec{

  "A Board" - {

    "should have an empty space in (1,1)" in {
      val newBoard = new Board()
      assert(newBoard.isSpaceEmpty(1,1) == true)
    }

    "should not have an empty space in (1,1)" in {
      val newBoard = new Board()
      newBoard.updateSpace(1,1,1)
      assert(newBoard.isSpaceEmpty(1,1) == false)
    }

  }

}
