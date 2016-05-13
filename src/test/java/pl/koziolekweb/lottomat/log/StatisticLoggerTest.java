package pl.koziolekweb.lottomat.log;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.junit.Test;
import pl.koziolekweb.lottomat.totolotek.Ball;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * TODO write JAVADOC!!!
 * User: koziolek
 */
public class StatisticLoggerTest {

	@Test
	public void shouldApplyTransformStatisticToLogCall() throws Exception {
		Ball ball1 = new Ball(1);
		Ball ball2 = new Ball(2);
		Ball ball3 = new Ball(3);
		Ball ball4 = new Ball(4);
		Ball ball5 = new Ball(5);
		Ball ball6 = new Ball(6);
		Collection<Ball> balls = Lists
				.newArrayList(
						ball1, ball2, ball3, ball4, ball5, ball6
				);

		Map<Ball, Integer> ballsMap = Maps.asMap(new HashSet<>(balls), b -> 1);

		Consumer<String> logger = mock(Consumer.class);

		Function<Stream<Entry<Ball, Integer>>, Stream<LogEntry<String>>> transformer = mock(Function.class);
		LogEntry<String> logEntry = mock(LogEntry.class);
		Stream<LogEntry<String>> stream = Stream.generate(() -> logEntry).limit(6);
		when(transformer.apply(anyObject())).thenReturn(stream);
		when(logEntry.logLine()).thenReturn("");

		StatisticLogger sut = new StatisticLogger(logger, transformer);

		sut.accept(ballsMap);

		verify(transformer, atLeastOnce()).apply(anyObject());
		verify(logEntry, atLeast(6)).logLine();
		verify(logger, atLeast(6)).accept("");
	}
}