

import java.util.*

fun List<Path>.shortest() = Optional.ofNullable(minBy(Path::distance))

fun List<Path>.filterWithStops(vararg points: Point): List<Path> {
    val stopsSet = points.toSet()
    return filter { path -> path.stops.containsAll(stopsSet) }
}
