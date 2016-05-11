package pl.koziolekweb.lottomat.totolotek;

import org.fest.assertions.Assertions;
import org.junit.Test;
import pl.koziolekweb.lottomat.totolotek.Ball.RawBallView;

/**
 * TODO write JAVADOC!!!
 * User: koziolek
 */
public class RawBallViewTest {

	@Test
	public void shouldAcceptPassBallValueToConsumer() throws Exception {
		Ball ball = new Ball(1);
		RawBallView sut = ball.new RawBallView();

		sut.accept(i -> Assertions.assertThat(i).isEqualTo(1));

	}
}