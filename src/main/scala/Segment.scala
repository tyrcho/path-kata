case class Point(name: String, x: Long, y: Long)

case class Segment(origin: Point, destination: Point) {
  override def toString = s"${origin.name} -${destination.name}"
  val x = origin.x - destination.x
  val y = origin.y - destination.y
  def distance: Double = Math.sqrt(x * x + y * y)
}

case class Path(segments: List[Segment]) {
  val distance = segments.map(_.distance).sum
}