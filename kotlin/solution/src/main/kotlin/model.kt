data class Point(val x: Int, val y: Int)

data class Segment(val origin: Point, val dest: Point) {

    val distance: Double

    init {
        fun delta(getCoordinate: Point.() -> Int) = origin.getCoordinate() - dest.getCoordinate()

        val deltaX = delta(Point::x)
        val deltaY = delta(Point::y)

        distance = Math.sqrt((deltaX * deltaX + deltaY * deltaY).toDouble())
    }
}

class Path(vararg segments: Segment) {

    val distance = segments.map{ it.distance }.sum()

    val stops = segments.flatMap { seg -> listOf(seg.origin, seg.dest) }.toSet()
}