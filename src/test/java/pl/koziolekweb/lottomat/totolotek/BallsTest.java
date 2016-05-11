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

	@Test
	public void smokeHashCodeAndEquals() throws Exception {
		Ball b1 = new Ball(1);
		Ball b11 = new Ball(1);
		Ball b2 = new Ball(2);

		assertThat(b1.hashCode()).isEqualTo(b11.hashCode());
		assertThat(b1.hashCode()).isNotEqualTo(b2.hashCode());
		assertThat(b1)
				.isEqualTo(b1)
				.isEqualTo(b11)
				.isNotEqualTo(b2)
				.isNotEqualTo(null)
				.isNotEqualTo(this);
	}
}