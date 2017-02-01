
class PathHelper {

  def shortestPath(paths: List[Path], stops: List[Point] = Nil): Option[Path] =
    if (paths.isEmpty) None
    else {
      val withStops = paths.filter(
        path => stops.forall(
          stop => path.segments.exists(s => s.origin == stop || s.destination == stop)))
      if (withStops.nonEmpty)
        Some(withStops.minBy(_.distance))
      else None
    }
}