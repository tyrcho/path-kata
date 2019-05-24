case class Point(x: Long, y: Long)

case class Segment(from: Point, to: Point) {
  def distance: Double =
    math.sqrt(
      (from.x - to.x) * (from.x - to.x) + (from.y - to.y) * (from.y - to.y)
    )
}

case class Path(segments: List[Segment]) {
  def stops: Set[Point] = (segments.map(_.from) ++ segments.map(_.to)).toSet

  def distance: Double = segments.map(_.distance).sum

  def to: Point = segments.last.to
  def from: Point = segments.head.from
}

object Path {
  def possiblePaths(from: Point,
                    to: Point,
                    segments: Set[Segment]): Set[Path] =
    if (from == to) Set(Path(Nil))
    else
      for {
        startSegment <- segments if startSegment.from == from
        path <- possiblePaths(startSegment.to, to, segments - startSegment)
      } yield Path(startSegment :: path.segments)

  def best(points: List[Point], paths: List[Path]): Option[Path] =
    shortest(stopAt(points, paths))

  def stopAt(requiredStops: List[Point], paths: List[Path]): List[Path] =
    paths.filter(path => requiredStops.forall(stop => path.stops(stop)))

  def stopAt(requiredStop: Point, paths: List[Path]): List[Path] =
    paths.filter(_.stops(requiredStop))

  def shortest(paths: List[Path]): Option[Path] =
    if (paths.nonEmpty)
      Some(paths.minBy(_.distance))
    else None
}
