package pl.koziolekweb.lottomat;

import org.fest.assertions.Assertions;
import org.junit.Test;

import java.util.Map;

import static org.fest.assertions.Assertions.assertThat;
import static org.junit.Assert.*;

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