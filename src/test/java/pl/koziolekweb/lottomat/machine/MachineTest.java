package pl.koziolekweb.lottomat.machine;

import com.google.common.collect.Lists;
import org.fest.assertions.Assertions;
import org.junit.Test;

import java.util.Collection;
import java.util.List;

/**
 * TODO write JAVADOC!!!
 * User: koziolek
 */
public class MachineTest {

	Machine<Integer> sut = new Machine<Integer>(){
		@Override
		protected Integer map(List<Integer> drawn) {
			return drawn.get(0);
		}
	};

	@Test
	public void shouldPickOneOfOne() throws Exception {

		Collection<Integer> input = Lists.newArrayList(1);

		Integer result = sut.pick(input, 1);

		Assertions.assertThat(result).isEqualTo(1);
	}
}