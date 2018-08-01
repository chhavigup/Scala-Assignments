import akka.actor.{ActorSystem, Props}
import akka.testkit.{ImplicitSender, TestKit}
import org.scalatest.{BeforeAndAfterAll, Matchers, WordSpecLike}
import ttt.entites._

class TicTacToeSpec extends TestKit(ActorSystem("MySpec")) with ImplicitSender
  with WordSpecLike with Matchers with BeforeAndAfterAll {

  override def afterAll {
    TestKit.shutdownActorSystem(system)
  }

  "An Game actor" should {

    val testRef = system.actorOf(Props[Game])

    "be able to change and return the state of tic tac toe game" in {
      testRef ! PlayStep(2, 1)
      expectMsgAllClassOf(classOf[TicTacToeMap])
    }

    "be able to send Tic Tac Toe Map and a GameOver when a condition is met" in {
      testRef ! PlayStep(1,1)
      testRef ! PlayStep(4,2)
      expectMsgAllClassOf(classOf[TicTacToeMap], classOf[TicTacToeMap], classOf[TicTacToeMap], classOf[TicTacToeMap])
      expectMsg(GameOver)
    }

    "be able to send PlaceAlreadyFilled Message when a PlayStep is sent on a non empty step" in {
      testRef ! PlayStep(1, 1)
      testRef ! PlayStep(1, 2)
      expectMsgAllClassOf(classOf[TicTacToeMap], classOf[PlaceAlreadyFilled])
    }
  }
}