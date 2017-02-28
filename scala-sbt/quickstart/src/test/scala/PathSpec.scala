import org.scalatest.{FlatSpec, Matchers}

class PathSpec extends FlatSpec with Matchers {

  val pa = Point("a", 0, 0)
  val pb = Point("b", 10, 10)
  val pc = Point("c", 20, 0)
  val pd = Point("d", 30, 0)
  val pe = Point("e", 40, 0)

  val ac = Segment(pa, pc)
  val bc = Segment(pb, pc)
  val ab = Segment(pa, pb)
  val cd = Segment(pc, pd)
  val de = Segment(pd, pe)
  // a---c--d--e
  //  \ /
  //   b

  "a segment" should "compute its distance" in {
    val distance = ac.distance
    distance shouldBe 20.0 +- 0.0001
  }

}
