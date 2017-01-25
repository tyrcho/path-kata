case class Path(segments: Seq[Segment] = Seq()) {
  def add(seg: Segment) = Path(seg +: segments)

  def distance = segments.map(_.distance).sum

  def stops = segments.map(_.start).toSet ++ segments.map(_.end)
}

case class Segment(start: Point, end: Point) {
  def distance = {
    val dx = start.x - end.x
    val dy = start.y - end.y
    math.sqrt(dx * dx + dy * dy).toInt
  }
}

case class Point(name: String, x: Int, y: Int)
