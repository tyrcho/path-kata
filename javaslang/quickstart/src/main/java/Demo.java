import static java.util.Comparator.comparingInt;

import javaslang.collection.Array;
import javaslang.collection.List;
import javaslang.collection.Set;
import javaslang.collection.Stream;
import javaslang.control.Option;

public class Demo {
	static int sqr(int x) {
		return x * x;
	}

	public static void main(String[] args) {
		List<Integer> ints = List.of(1, 2, 3);

		Stream<Integer> doubles = ints.map(i -> i * 2).toStream();
		Stream<Integer> squares = doubles.map(Demo::sqr);

		Set<Integer> uniques = squares.toSet();

		Stream<Integer> evens = uniques.filter(x -> x % 2 == 0).toStream();
		Array<Integer> evensArray = evens.toArray();

		Option<Integer> maybeMin = ints.minBy(comparingInt(x -> x));
		boolean hasMin = maybeMin.isDefined();
		Integer min = maybeMin.getOrElse(() -> -1);

		long sum = ints.map(x -> 1 + x).sum().longValue();

		Stream<Integer> posAndNegs = ints.flatMap(i -> List.of(i, -i)).toStream();
	}
}