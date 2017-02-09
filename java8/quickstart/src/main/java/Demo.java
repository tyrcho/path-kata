import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.toSet;
import static java.util.stream.Stream.of;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

public class Demo {
	static int sqr(int x) {
		return x * x;
	}

	public static void main(String[] args) {
		List<Integer> ints = Arrays.asList(1, 2, 3);

		Stream<Integer> doubles = ints.stream().map(i -> i * 2);
		Stream<Integer> squares = doubles.map(Demo::sqr);

		Set<Integer> uniques = squares.collect(toSet());

		Stream<Integer> evens = uniques.stream().filter(x -> x % 2 == 0);
		Integer[] evensArray = evens.toArray(Integer[]::new);

		Optional<Integer> maybeMin = ints.stream().min(comparingInt(x -> x));
		boolean hasMin = maybeMin.isPresent();
		Integer min = maybeMin.orElseGet(() -> -1);

		long sum = ints.stream().mapToInt(x -> 1 + x).sum();

		Stream<Integer> posAndNegs = ints.stream().flatMap(i -> of(i, -i));
	}
}