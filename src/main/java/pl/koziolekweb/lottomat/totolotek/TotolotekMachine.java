package pl.koziolekweb.lottomat.totolotek;

import com.google.common.base.Preconditions;
import pl.koziolekweb.fun.Function0;
import pl.koziolekweb.lottomat.machine.Machine;

import java.util.Collection;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * TODO write JAVADOC!!!
 * User: koziolek
 */
public class TotolotekMachine extends Machine<Ball, ResultsOfDraw> {

	private static final Balls BALLS = new Balls();

	@Override
	protected Function0<Collection<Ball>> getData() {
		return BALLS;
	}

	@Override
	protected Function<Collection<Ball>, ResultsOfDraw> mapToResult() {
		return ResultsOfDraw::new;
	}

	@Override
	protected Integer limit() {
		return 6;
	}

	public static class Balls implements Function0<Collection<Ball>> {

		private static final Set<Ball> BALL_SET = IntStream.rangeClosed(1, 49).boxed().map(Ball::new).collect(Collectors
				.toSet());

		@Override
		public Collection<Ball> apply() {
			return BALL_SET;
		}
	}


}
