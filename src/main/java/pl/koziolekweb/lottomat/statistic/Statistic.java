package pl.koziolekweb.lottomat.statistic;

import pl.koziolekweb.fun.MapMerge;
import pl.koziolekweb.lottomat.totolotek.Ball;
import pl.koziolekweb.lottomat.totolotek.TotolotekMachine.TotolotekResultOfDraw;

import java.util.Map;
import java.util.function.Consumer;

/**
 * TODO write JAVADOC!!!
 * User: koziolek
 */
public class Statistic {

	private final Map<Ball, Integer> results;

	private final TotolotekResultToMap map = new TotolotekResultToMap();

	private final MapMerge<Ball, Integer> merge = new MapMerge<>((l, r) -> l + r);

	private Statistic(Map<Ball, Integer> results) {
		this.results = results;
	}

	public Statistic append(TotolotekResultOfDraw resultOfDraw) {
		return new Statistic(merge.apply(map.apply(resultOfDraw), results));
	}

	public Statistic append(Statistic other) {
		return new Statistic(merge.apply(other.results, results));
	}

	public class RawStatisticView {

		public void accept(Consumer<Map<Ball, Integer>> consumer) {
			consumer.accept(Statistic.this.results);
		}
	}

	public static class StatisticBuilder {

		private Map<Ball, Integer> results;

		public StatisticBuilder withResults(Map<Ball, Integer> results) {
			this.results = results;
			return this;
		}

		public static StatisticBuilder statistic() {
			return new StatisticBuilder();
		}

		public Statistic build() {
			return new Statistic(results);
		}
	}
}
