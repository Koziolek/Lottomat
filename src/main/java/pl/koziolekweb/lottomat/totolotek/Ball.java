package pl.koziolekweb.lottomat.totolotek;

import java.util.Objects;
import java.util.function.Consumer;

/**
 * TODO write JAVADOC!!!
 * User: koziolek
 */
public class Ball {

	private final Integer value;

	public Ball(Integer value) {
		this.value = value;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Ball)) return false;
		Ball ball = (Ball) o;
		return Objects.equals(value, ball.value);
	}

	@Override
	public int hashCode() {
		return Objects.hash(value);
	}

	public class RawBallView{

		public void accept(Consumer<Integer> consumer){

		}
	}
}
