package pl.koziolekweb.lottomat.statistic;

import pl.koziolekweb.lottomat.totolotek.Ball;

import java.util.Map;
import java.util.function.Consumer;

/**
 * TODO write JAVADOC!!!
 * User: koziolek
 */
public class Statistic {

	private final Map<Ball, Integer> results;

	public Statistic(Map<Ball, Integer> results) {
		this.results = results;
	}

	public class RawStatisticView{

		public void accept(Consumer<Map<Ball, Integer>> consumer) {
			consumer.accept(Statistic.this.results);
		}
	}

}
