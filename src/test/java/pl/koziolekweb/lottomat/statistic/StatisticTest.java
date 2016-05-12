package pl.koziolekweb.lottomat.statistic;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.junit.Test;
import pl.koziolekweb.lottomat.totolotek.Ball;
import pl.koziolekweb.lottomat.totolotek.TotolotekMachine.TotolotekResultOfDraw;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;

import static org.fest.assertions.Assertions.assertThat;
import static org.fest.assertions.MapAssert.entry;

/**
 * TODO write JAVADOC!!!
 * User: koziolek
 */
public class StatisticTest {

	@Test
	public void shouldAppendCreateNewStatistic() throws Exception {
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

		Statistic in = Statistic.StatisticBuilder.statistic().withResults(Maps.newHashMap()).build();

		Statistic out = in.append(resultOfDraw);

		assertThat(out).isNotNull().isNotEqualTo(in);
		in.new RawStatisticView().accept(map -> assertThat(map).hasSize(0));
		out.new RawStatisticView().accept(map -> assertThat(map).hasSize(6).includes(
				entry(ball1, 1),
				entry(ball2, 1),
				entry(ball3, 1),
				entry(ball4, 1),
				entry(ball5, 1),
				entry(ball6, 1)
		));
	}

	@Test
	public void shouldAppendMergeStatistic() throws Exception {
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

		Map<Ball, Integer> ballsMap = Maps.asMap(new HashSet<Ball>(balls), b -> 1);

		Statistic in = Statistic.StatisticBuilder.statistic().withResults(Maps.newHashMap()).build();

		Statistic in2 = Statistic.StatisticBuilder.statistic().withResults(ballsMap).build();

		Statistic out = in.append(in2);

		assertThat(out).isNotNull().isNotEqualTo(in);
		in.new RawStatisticView().accept(map -> assertThat(map).hasSize(0));
		out.new RawStatisticView().accept(map -> assertThat(map).hasSize(6).includes(
				entry(ball1, 1),
				entry(ball2, 1),
				entry(ball3, 1),
				entry(ball4, 1),
				entry(ball5, 1),
				entry(ball6, 1)
		));
	}


}