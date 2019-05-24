def sqr(i: Int): Int = i * i

val ints = List(1, 2, 3)

ints.map(i => i * 2)
ints.map(sqr)
ints.sum
ints.map(sqr).sum

ints.min

ints.minBy(i => -i)

ints.map(i => List(i, 2 * i))
ints.flatMap(i => List(i, 2 * i))
ints.flatMap(i => List(i, 2 * i)).toSet

ints.contains(2)

ints.filter(i => i % 2 == 0)

val maybeInt: Option[Int] = Some(1)
maybeInt.isEmpty

val noInt: Option[Int] = None
maybeInt.isEmpty

