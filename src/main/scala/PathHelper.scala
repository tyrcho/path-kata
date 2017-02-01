
class PathHelper {
  def findPath(list: List[Segment], pa: Point, pb: Point): Option[List[Segment]] = {
    if (list.isEmpty) None
    else if (pa == pb) Some(Nil)
    else {
      val destinations = findDestinations(list, pa)
      val allPaths = for {
        destination <- destinations
        path <- findPath(list, destination, pb)
      } yield Segment(pa, destination) :: path
      allPaths match {
        case Nil =>
          None
        case paths => Some(paths.minBy(getDistance))
      }
    }
  }

  def findDestinations(list: List[Segment], pa: Point) = {
    for {
      segment <- list
      if segment.origin == pa
    } yield segment.destination
  }

  def getDistance(path: List[Segment]): Double = {
    path.map(_.distance).sum
  }
}