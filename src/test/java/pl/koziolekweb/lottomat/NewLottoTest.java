package pl.koziolekweb.lottomat;

import org.junit.Test;
import pl.koziolekweb.lottomat.statistic.Statistic;

import static org.fest.assertions.Assertions.assertThat;

/**
 * TODO write JAVADOC!!!
 * User: koziolek
 */
public class NewLottoTest {

	@Test
	public void shouldStatReturnInitialStatistic() throws Exception {
		NewLotto lotto = new NewLotto();

		Statistic stat = lotto.stat(1);

		stat.new RawStatisticView().accept(m -> assertThat(m)
				.hasSize(49)
		);
	}
}