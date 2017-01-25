
import org.junit.runner.RunWith
import org.scalatest.FlatSpec
import org.scalatest.Matchers
import org.scalatest.junit.JUnitRunner
import org.scalatest.prop.PropertyChecks

@RunWith(classOf[JUnitRunner])
class PathSpec extends FlatSpec with Matchers {
  val helper = new PathHelper
  val points = Seq(Point("a", 0, 0), Point("b", 10, 10), Point("c", 20, 0), Point("d", 30, 0), Point("e", 40, 0))
  // a---c--d--e
  //  \ /
  //   b

  def point(name: String) = points.filter(_.name == name).head
  def train(start: String, end: String) = Segment(point(start), point(end))

  "a path helper" should "find trivial path" in {
    val path = helper.findPath(Seq(train("a", "b")), "a", "b")
    path shouldBe Some(Seq(train("a", "b")))
  }

  it should "find no path if no segments are used" in {
    val path = helper.findPath(Seq(), "a", "b")
    path shouldBe None
  }

  it should "find an empty path if start == end " in {
    val path = helper.findPath(Seq(), "a", "a")
    path shouldBe Some(Seq())
  }

  it should "find a path from several segments" in {
    val path = helper.findPath(Seq(train("a", "b"), train("a", "e"), train("c", "d"), train("b", "c")), "a", "d")
    path shouldBe Some(Seq(train("a", "b"), train("b", "c"), train("c", "d")))
  }

  it should "find the shortest path" in {
    val path = helper.findPath(Seq(train("a", "b"), train("a", "c"), train("c", "d"), train("b", "c")), "a", "d")
    path shouldBe Some(Seq(train("a", "c"), train("c", "d")))
  }

  it should "find a path with a stop constraint" in {
    val path = helper.findPath(Seq(train("a", "b"), train("a", "c"), train("c", "d"), train("b", "c")), "a", "d", stops = Seq("b"))
    path shouldBe Some(Seq(train("a", "b"), train("b", "c"), train("c", "d")))
  }
}