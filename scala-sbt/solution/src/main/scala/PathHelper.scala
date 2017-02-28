
class PathHelper {
  def shortestPath(paths: List[Path], stops: List[Point] = Nil): Option[Path] =
    filter(paths, stops) match {
      case Nil       => None
      case withStops => Some(withStops.minBy(path => path.distance))
    }

  def shortestPathPatternMatching(paths: List[Path]): Option[Path] = paths match {
    case Nil    => None
    case h :: t => Some(h)
  }

  def filter(paths: List[Path], stop: Point) =
    paths.filter(path => path.stops.contains(stop))

  def filter(paths: List[Path], stops: List[Point]) =
    paths.filter(p => stops.forall(p.stops.contains))

}