import org.scalatest._
import freespec._

class PlayerTest extends AnyFreeSpec {

  "A Player" - {

    "should have name Bob" in {
      val newPlayer = new Player("Bob")
      assert(newPlayer.name == "Bob")
    }

    "should have name George" in {
      val newPlayer = new Player("Bob")
      newPlayer.changeName("George")
      assert(newPlayer.name == "George")
    }

  }

}
