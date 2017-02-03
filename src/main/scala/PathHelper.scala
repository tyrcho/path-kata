
class PathHelper {
  def shortestPath(paths: List[Path], stops: List[Point] = Nil): Option[Path] = {
 val withStops = filter(paths, stops)
    if (withStops .nonEmpty)
      Some(withStops .minBy(_.distance))
    else None
  }

  def filter(paths: List[Path], stop: Point) =
    paths.filter(_.stops.contains(stop))

  def filter(paths: List[Path], stops: List[Point]) =
    paths.filter(p => stops.forall(p.stops.contains))

}