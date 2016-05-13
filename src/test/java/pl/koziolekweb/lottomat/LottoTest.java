package pl.koziolekweb.lottomat;

import org.junit.Test;

import java.util.Map;

import static org.fest.assertions.Assertions.assertThat;

/**
 * TODO write JAVADOC!!!
 * User: koziolek
 */
public class LottoTest {

	@Test
	public void shouldStatReturnMapOf49Entries() throws Exception {
		Lotto sut = new Lotto();

		Map<Integer, Integer> stat = sut.stat(1);

		assertThat(stat).hasSize(49);

	}
}