package pl.koziolekweb.lottomat.log;

import org.junit.Test;
import pl.koziolekweb.lottomat.totolotek.Ball;

import static org.fest.assertions.Assertions.assertThat;

/**
 * TODO write JAVADOC!!!
 * User: koziolek
 */
public class BallCardinalityLogEntryTest {

	@Test
	public void shouldCreateProperLogLine() throws Exception {
		Ball b1 = new Ball(1);

		BallCardinalityLogEntry entry = new BallCardinalityLogEntry(b1, 1);

		assertThat(entry.logLine()).isEqualTo("1=1");

	}
}