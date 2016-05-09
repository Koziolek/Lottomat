package pl.koziolekweb.lottomat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * TODO write JAVADOC!!!
 * User: koziolek
 */
public class Lotto {


	public static final int NBR = 100_000_000;

	public static void main(String[] args) {
		Lotto lotto = new Lotto();

		Map<Integer, Integer> stat = lotto.stat(NBR);
		System.out.println(stat);

		stat.entrySet().stream().sorted(Comparator.comparing(e -> e.getValue(), (l, r) -> l.compareTo(r))).forEach(e -> {
			System.out.println(e.getKey() + "=" + ((e.getValue() * 100.) / NBR) + "%");
		});


	}

	private Set<Integer> draw() {
		List<Integer> all = IntStream.rangeClosed(1, 49).boxed().collect(Collectors.toList());
		Collections.shuffle(all);
		return all.stream().limit(6).collect(Collectors.toSet());
	}

	public Map<Integer, Integer> stat(int param) {
		Map<Integer, List<Integer>> ll = new HashMap<>();
		IntStream.rangeClosed(1, 49).boxed().forEach(i -> ll.put(i, new ArrayList<>()));
		for (int c = 0; c < param; c++) {
			Set<Integer> draw = draw();
			Map<Integer, List<Integer>> collect = draw.stream().collect(Collectors.groupingBy(i -> i));
			merge(collect, ll);
		}
		return count(ll);

	}

	private Map<Integer, Integer> count(Map<Integer, List<Integer>> l) {

		return l.entrySet().stream().collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue().size()));
	}

	private Map<Integer, List<Integer>> merge(Map<Integer, List<Integer>> l, Map<Integer, List<Integer>> r) {
		r.entrySet().forEach(e ->

				e.getValue().addAll(l.getOrDefault(e.getKey(), Collections.emptyList()))

		);

		return r;

	}
}
