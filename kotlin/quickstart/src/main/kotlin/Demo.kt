
import java.util.*

internal fun sqr(x: Int): Int {
    return x * x
}

fun main(args: Array<String>) {
    val ints = listOf(1, 2, 3)

    val doubles = ints.map { i -> i * 2 }
    val squares = doubles.map(::sqr)

    val uniques = squares.toSet()

    val evens = uniques.filter { x -> x % 2 == 0 }
    val evensArray = evens.toIntArray()

    val maybeMin = Optional.ofNullable(ints.min())
    val hasMin = maybeMin.isPresent
    val min = maybeMin.orElseGet { -1 }

    val sum = ints.map { x -> 1 + x }.sum()

    val posAndNegs = ints.flatMap { i -> listOf(i, -i) }
}