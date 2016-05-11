package pl.koziolekweb.lottomat.machine;

import com.google.common.collect.Lists;
import org.fest.assertions.Assertions;
import org.junit.Test;
import pl.koziolekweb.fun.Function0;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Function;

/**
 * TODO write JAVADOC!!!
 * User: koziolek
 */
public class MachineTest {

	@Test
	public void shouldPickOneOfOne() throws Exception {

		Machine<Integer, Integer> sut = new Machine<Integer, Integer>() {

			@Override
			protected Function0<Collection<Integer>> getData() {
				return () -> Lists.newArrayList(1);
			}

			@Override
			protected Function<Collection<Integer>, Integer> mapToResult() {
				return c -> c.stream().findFirst().get();
			}

			@Override
			protected Integer limit() {
				return 1;
			}
		};


		Integer result = sut.pick();

		Assertions.assertThat(result).isEqualTo(1);
	}

	@Test
	public void shouldRandomizeCopyOfInput() throws Exception {
		ArrayList<Integer> input = Lists.newArrayList(1, 2, 3, 4, 5);

		Machine<Integer, Integer> sut = new Machine<Integer, Integer>() {

			@Override
			protected Function0<Collection<Integer>> getData() {
				return () -> input;
			}

			@Override
			protected Function<Collection<Integer>, Integer> mapToResult() {
				return c -> c.stream().findFirst().get();
			}

			@Override
			protected Integer limit() {
				return 1;
			}
		};


		Integer result = sut.pick();

		Assertions.assertThat(result).isIn(1, 2, 3, 4, 5);
		Assertions.assertThat(input).hasSize(5).containsExactly(1, 2, 3, 4, 5);

	}
}