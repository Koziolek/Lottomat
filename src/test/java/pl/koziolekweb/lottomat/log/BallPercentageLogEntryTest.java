package pl.koziolekweb.lottomat.log;

import org.junit.Test;
import pl.koziolekweb.lottomat.totolotek.Ball;

import static org.fest.assertions.Assertions.assertThat;

/**
 * TODO write JAVADOC!!!
 * User: koziolek
 */
public class BallPercentageLogEntryTest {

	@Test
	public void shouldCreateProperLogLine() throws Exception {
		Ball b1 = new Ball(1);

		BallPercentageLogEntry entry = new BallPercentageLogEntry(b1, 1, 1);

		assertThat(entry.logLine()).isEqualTo("1=100,00%");

	}

}