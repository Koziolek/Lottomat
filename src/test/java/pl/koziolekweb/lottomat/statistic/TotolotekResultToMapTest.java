package pl.koziolekweb.lottomat.statistic;

import com.google.common.collect.Lists;
import org.fest.assertions.Assertions;
import org.junit.Test;
import pl.koziolekweb.lottomat.totolotek.Ball;
import pl.koziolekweb.lottomat.totolotek.TotolotekMachine.TotolotekResultOfDraw;

import java.util.Collection;
import java.util.Map;

import static org.fest.assertions.MapAssert.entry;

/**
 * TODO write JAVADOC!!!
 * User: koziolek
 */
public class TotolotekResultToMapTest {

	@Test
	public void shouldCreateMapFromResults() throws Exception {
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
		TotolotekResultOfDraw resultOfDraw = new TotolotekResultOfDraw(balls);

		TotolotekResultToMap sut = new TotolotekResultToMap();

		Map<Ball, Integer> result = sut.apply(resultOfDraw);

		Assertions.assertThat(result)
				.hasSize(6)
				.includes(
						entry(ball1, 1),
						entry(ball2, 1),
						entry(ball3, 1),
						entry(ball4, 1),
						entry(ball5, 1),
						entry(ball6, 1)
				);

	}
}