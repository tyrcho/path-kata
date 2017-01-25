
class PathHelper {

  def findPath(segments: Seq[Segment], from: Point, to: Point, stops: Seq[Point] = Nil): Option[Path] = {
    def pathsFrom(from: Point): Seq[Path] = {
      if (from == to) Seq(Path())
      else for {
        s <- segments
        if s.start == from
        path <- pathsFrom(s.end)
      } yield path.add(s)
    }

    pathsFrom(from).filter(path => stops.forall(path.stops.contains)) match {
      case Nil       => None
      case withStops => Some(withStops.minBy(_.distance))
    }
  }

}