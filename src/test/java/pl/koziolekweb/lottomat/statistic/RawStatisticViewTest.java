package pl.koziolekweb.lottomat.statistic;

import org.junit.Test;
import pl.koziolekweb.lottomat.statistic.Statistic.RawStatisticView;
import pl.koziolekweb.lottomat.totolotek.Ball;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Matchers.anyMap;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * TODO write JAVADOC!!!
 * User: koziolek
 */
public class RawStatisticViewTest {

	@Test
	public void shouldAcceptPassStatisticMapToConsumer() throws Exception {
		Statistic machine = new Statistic.StatisticBuilder().withResults(new HashMap<>()).build();

		RawStatisticView sut = machine.new RawStatisticView();

		Consumer<Map<Ball, Integer>> consumer = mock(Consumer.class);
		doAnswer(invocation ->
				assertThat((Map<Ball, Integer>) invocation.getArguments()[0])
						.hasSize(0)
		)
				.when(consumer).accept(anyMap());

		sut.accept(consumer);
		verify(consumer, atLeastOnce()).accept(anyMap());

	}
}