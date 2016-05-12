package pl.koziolekweb.fun;

import com.google.common.collect.Maps;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.verification.VerificationMode;

import java.util.Map;

import static org.fest.assertions.Assertions.assertThat;
import static org.fest.assertions.MapAssert.entry;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

/**
 * TODO write JAVADOC!!!
 * User: koziolek
 */
public class MapMergeTest {

	private MapMerge<Integer, Integer> sut;
	private Map<Integer, Integer> map1;
	private Map<Integer, Integer> map2;

	@Before
	public void setUp() throws Exception {
		sut = new MapMerge<>((l, r) -> l + r);
		map1 = Maps.newHashMap();
		map2 = Maps.newHashMap();

	}

	@Test
	public void shouldMergeEmptyEmptyGivesEmpty() throws Exception {

		Map<Integer, Integer> result = sut.apply(map1, map2);

		assertThat(result).isEmpty();

	}

	@Test
	public void shouldMergeEmptyAndNotEmptyGivesNotEmpty() throws Exception {

		map1.put(1, 1);

		Map<Integer, Integer> result = sut.apply(map1, map2);

		assertThat(result)
				.isNotEmpty()
				.hasSize(1)
				.includes(entry(1, 1));
	}

	@Test
	public void shouldMergeNotEmptyAndEmptyGivesNotEmpty() throws Exception {

		map2.put(1, 1);

		Map<Integer, Integer> result = sut.apply(map1, map2);

		assertThat(result)
				.isNotEmpty()
				.hasSize(1)
				.includes(entry(1, 1));
	}

	@Test
	public void shouldMergeNotEmptyAndNotEmptyGivesSum() throws Exception {

		map1.put(1, 1);
		map2.put(2, 2);

		Map<Integer, Integer> result = sut.apply(map1, map2);

		assertThat(result)
				.isNotEmpty()
				.hasSize(2)
				.includes(entry(1, 1), entry(2, 2));
	}


	@Test
	public void shouldMergeNotEmptyAndNotEmptyGivesSumOnDuplicates() throws Exception {

		map1.put(1, 1);
		map2.put(1, 1);

		Map<Integer, Integer> spy1 = spy(map1);
		Map<Integer, Integer> spy2 = spy(map2);


		Map<Integer, Integer> result = sut.apply(spy1, spy2);

		assertThat(result)
				.isNotEmpty()
				.hasSize(1)
				.includes(entry(1, 2));

		verify(spy1, never()).put(anyInt(), anyInt());
		verify(spy2, never()).put(anyInt(), anyInt());
	}
}