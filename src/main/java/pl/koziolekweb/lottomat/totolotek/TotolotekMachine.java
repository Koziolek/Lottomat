package pl.koziolekweb.lottomat.totolotek;

import com.google.common.base.Preconditions;
import pl.koziolekweb.fun.Function0;
import pl.koziolekweb.lottomat.machine.Machine;
import pl.koziolekweb.lottomat.totolotek.TotolotekMachine.TotolotekResultOfDraw;

import java.util.Collection;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.String.format;

/**
 * TODO write JAVADOC!!!
 * User: koziolek
 */
public class TotolotekMachine extends Machine<Ball, TotolotekResultOfDraw> {

	private static final Balls BALLS = new Balls();

	@Override
	protected Function0<Collection<Ball>> getData() {
		return BALLS;
	}

	@Override
	protected Function<Collection<Ball>, TotolotekResultOfDraw> mapToResult() {
		return TotolotekResultOfDraw::new;
	}

	@Override
	protected Integer limit() {
		return 6;
	}

	public class MachineContentView{

		public void accept(Consumer<Collection<Ball>> consumer) {
			consumer.accept(BALLS.apply());
		}
	}

	public static class TotolotekResultOfDraw extends ResultsOfDraw {

		public TotolotekResultOfDraw(Collection<Ball> balls) {
			super(balls);
			Preconditions.checkArgument(balls.size() == 6, format("Invalid size of result set! Is %d but should be", balls.size()));
		}

		public class RawTotolotekResultOfDrawView {

			public void accept(Consumer<Collection<Ball>> consumer) {
				TotolotekResultOfDraw.this.new RawResultsOfDrawView().accept(consumer);
			}
		}
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
