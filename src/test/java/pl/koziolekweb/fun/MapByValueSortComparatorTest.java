package pl.koziolekweb.fun;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.fest.assertions.Assertions.assertThat;

/**
 * TODO write JAVADOC!!!
 * User: koziolek
 */
public class MapByValueSortComparatorTest {

	@Test
	public void shouldCompareReturnValidValues() throws Exception {
		Map.Entry<Integer, Integer> e1 = new HashMap.SimpleEntry(1, 1);
		Map.Entry<Integer, Integer> e2 = new HashMap.SimpleEntry(1, 2);

		MapByValueSortComparator<Integer, Integer> cmp = new MapByValueSortComparator<>(Integer::compare);

		assertThat(cmp.compare(e1, e2)).isLessThan(0);
		assertThat(cmp.compare(e2, e1)).isGreaterThan(0);
		assertThat(cmp.compare(e1, e1)).isEqualTo(0);

	}
}