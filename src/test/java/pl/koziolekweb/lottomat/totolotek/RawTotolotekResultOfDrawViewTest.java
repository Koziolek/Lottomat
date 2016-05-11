package pl.koziolekweb.lottomat.totolotek;

import com.google.common.collect.Lists;
import org.junit.Test;
import pl.koziolekweb.lottomat.totolotek.TotolotekMachine.TotolotekResultOfDraw;
import pl.koziolekweb.lottomat.totolotek.TotolotekMachine.TotolotekResultOfDraw.RawTotolotekResultOfDrawView;

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
public class RawTotolotekResultOfDrawViewTest {
	@Test
	public void shouldAcceptPassBallsCollectionToConsumer() throws Exception {
		Ball ball1 = new Ball(1);
		Ball ball2 = new Ball(2);
		Ball ball3 = new Ball(3);
		Ball ball4 = new Ball(4);
		Ball ball5 = new Ball(5);
		Ball ball6 = new Ball(6);

		List<Ball> balls = Lists.newArrayList(ball1, ball2, ball3, ball4, ball5, ball6);
		TotolotekResultOfDraw resultsOfDraw = new TotolotekResultOfDraw(balls);

		RawTotolotekResultOfDrawView sut = resultsOfDraw.new RawTotolotekResultOfDrawView();

		Consumer<Collection<Ball>> consumer = mock(Consumer.class);
		doAnswer(invocation ->
				assertThat((List<Ball>) invocation.getArguments()[0])
						.isEqualTo(balls).containsOnly(ball1, ball2, ball3, ball4, ball5, ball6)
		)
				.when(consumer).accept(balls);

		sut.accept(consumer);
		verify(consumer, atLeastOnce()).accept(balls);

	}
}