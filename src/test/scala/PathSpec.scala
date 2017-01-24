
import org.junit.runner.RunWith
import org.scalatest.FlatSpec
import org.scalatest.Matchers
import org.scalatest.junit.JUnitRunner
import org.scalatest.prop.PropertyChecks

@RunWith(classOf[JUnitRunner])
class GildedRoseSpec extends FlatSpec with Matchers {
  val helper = new PathHelper
  val trainAB = Segment(start = "a", end = "b", mode = "train", duration = 100, distance = 80, price = 10)

  "a path helper" should "find trivial path" in {
    val path = helper.findPath(Seq(trainAB), "a", "b")
    path shouldBe Some(trainAB)
  }

  it should "find no path if no segments are used" in {
    val path = helper.findPath(Seq(), "a", "b")
    path shouldBe None
  }
}