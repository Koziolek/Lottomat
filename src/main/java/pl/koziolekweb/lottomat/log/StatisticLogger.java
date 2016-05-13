package pl.koziolekweb.lottomat.log;

import pl.koziolekweb.lottomat.totolotek.Ball;

import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * TODO write JAVADOC!!!
 * User: koziolek
 */
public class StatisticLogger<T> implements Consumer<Map<Ball, Integer>> {

	private final Consumer<T> logger;

	private final Function<Stream<Entry<Ball, Integer>>, Stream<LogEntry<T>>> transformer;


	public StatisticLogger(Consumer<T> logger,
	                       Function<Stream<Entry<Ball, Integer>>, Stream<LogEntry<T>>> transformer) {
		this.logger = logger;
		this.transformer = transformer;
	}

	@Override
	public void accept(Map<Ball, Integer> ballIntegerMap) {
		transformer.apply(ballIntegerMap.entrySet()
				.stream())
				.map(LogEntry::logLine)
				.forEach(logger);
	}
}
