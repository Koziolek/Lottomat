package pl.koziolekweb.lottomat.totolotek;

import com.google.common.collect.Lists;
import org.junit.Test;
import pl.koziolekweb.lottomat.totolotek.ResultsOfDraw.RawResultsOfDrawView;

import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * TODO write JAVADOC!!!
 * User: koziolek
 */
public class RawResultsOfDrawViewTest {

	@Test
	public void shouldAcceptPassBallsCollectionToConsumer() throws Exception {
		Ball ball1 = new Ball(1);
		Ball ball2 = new Ball(2);

		List<Ball> balls = Lists.newArrayList(ball1, ball2);
		ResultsOfDraw resultsOfDraw = new ResultsOfDraw(balls);

		RawResultsOfDrawView sut = resultsOfDraw.new RawResultsOfDrawView();

		Consumer<Collection<Ball>> consumer = mock(Consumer.class);
		doAnswer(invocation ->
				assertThat((List<Ball>) invocation.getArguments()[0])
						.isEqualTo(balls).containsOnly(ball1, ball2)
		)
				.when(consumer).accept(balls);

		sut.accept(consumer);
		verify(consumer, atLeastOnce()).accept(balls);

	}

}