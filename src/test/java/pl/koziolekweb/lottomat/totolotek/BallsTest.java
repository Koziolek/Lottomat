package pl.koziolekweb.lottomat.totolotek;

import org.junit.Test;
import pl.koziolekweb.lottomat.totolotek.TotolotekMachine.Balls;

import java.util.Collection;

import static org.fest.assertions.Assertions.assertThat;

/**
 * TODO write JAVADOC!!!
 * User: koziolek
 */
public class BallsTest {

	private Balls sut = new Balls();

	@Test
	public void shouldBallsCreate49UniqueBalls() throws Exception {
		Collection<Ball> balls = sut.apply();

		assertThat(balls)
				.hasSize(49)
				.doesNotHaveDuplicates();
	}
}