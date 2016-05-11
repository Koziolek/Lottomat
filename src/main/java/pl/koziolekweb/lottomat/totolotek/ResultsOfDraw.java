package pl.koziolekweb.lottomat.totolotek;

import java.util.Collection;
import java.util.function.Consumer;

/**
 * TODO write JAVADOC!!!
 * User: koziolek
 */
public class ResultsOfDraw {

	private final Collection<Ball> balls;

	public ResultsOfDraw(Collection<Ball> balls) {
		this.balls = balls;
	}

	public class RawResultsOfDrawView {

		public void accept(Consumer<Collection<Ball>> consumer) {
			consumer.accept(balls);
		}
	}

}
