package pl.koziolekweb.lottomat.totolotek;

import org.fest.assertions.Assertions;
import org.junit.Test;
import pl.koziolekweb.lottomat.totolotek.Ball.RawBallView;

import java.util.function.Consumer;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * TODO write JAVADOC!!!
 * User: koziolek
 */
public class RawBallViewTest {

	@Test
	public void shouldAcceptPassBallValueToConsumer() throws Exception {
		Ball ball = new Ball(1);
		RawBallView sut = ball.new RawBallView();

		Consumer<Integer> consumer = mock(Consumer.class);
		doAnswer(invocation -> Assertions.assertThat(invocation.getArguments()[0]).isEqualTo(1))
				.when(consumer).accept(1);

		sut.accept(consumer);
		verify(consumer, atLeastOnce()).accept(1);

	}
}