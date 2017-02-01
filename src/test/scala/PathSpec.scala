
import org.junit.runner.RunWith
import org.scalatest.FlatSpec
import org.scalatest.Matchers
import org.scalatest.junit.JUnitRunner
import org.scalatest.prop.PropertyChecks

@RunWith(classOf[JUnitRunner])
class PathSpec extends FlatSpec with Matchers {
  val helper = new PathHelper
  val pa = Point("a", 0, 0)
  val pb = Point("b", 10, 10)
  val pc = Point("c", 20, 0)
  val pd = Point("D", 30, 0)
  val pe = Point("E", 40, 0)
  val pz = Point("Z", 40, 40)

  // a---c--d--e
  //  \ /
  //   b

  val ab = Segment(pa, pb)
  val ac = Segment(pa, pc)
  val bc = Segment(pb, pc)
  val cd = Segment(pc, pd)
  val de = Segment(pd, pe)

  val acde = Path(List(ac, cd, de))
  val abcde = Path(List(ab, bc, cd, de))

  "a segment" should "know its distance" in {
    //When
    val distance = ac.distance
    //Then
    distance shouldBe 20.0 +- 0.0001
  }

  "a path" should "know its distance" in {
    //Given
    val path = Path(List(ac, cd))
    //When
    val distance = path.distance
    //Then
    distance shouldBe 30.0 +- 0.0001
  }

  "a path helper" should "find nothing given no paths" in {
    helper.shortestPath(Nil) shouldBe None
  }

  it should "find the shortest path" in {
    helper.shortestPath(List(acde, abcde)) shouldBe Some(acde)
  }

  it should "find the shortest path with a forced stop" in {
    helper.shortestPath(List(acde, abcde), List(pb)) shouldBe Some(abcde)
  }

  it should "not find a path with impossible stops" in {
    helper.shortestPath(List(acde, abcde), List(pb, pz)) shouldBe None
  }
}