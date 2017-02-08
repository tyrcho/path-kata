import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo {
	static int sqr(int x) {
		return x * x;
	}

	public static void main(String[] args) {
		List<Integer> ints = Arrays.asList(1, 2, 3);
		
		Stream<Integer> doubles = ints.stream().map(i -> i * 2);
		Stream<Integer> squares = doubles.map(Demo::sqr);
		
		Set<Integer> uniques = squares.collect(Collectors.toSet());
		
		Stream<Integer> evens = uniques.stream().filter(x -> x % 2 == 0);
		Integer[] evensArray = evens.toArray(Integer[]::new);
		
		Optional<Integer> maybeMin = ints.stream().min(Comparator.comparingInt(x -> x));
		boolean hasMin = maybeMin.isPresent();
		Integer min = maybeMin.orElseGet(() -> -1);
		
		long sum = ints.stream().collect(Collectors.summarizingInt(x -> x)).getSum();
		
		Stream<Integer> posAndNegs = ints.stream().flatMap(i -> Stream.of(i, -i));
	}
}
