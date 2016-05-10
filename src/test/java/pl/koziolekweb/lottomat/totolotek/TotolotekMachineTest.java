package pl.koziolekweb.lottomat.totolotek;

import org.fest.assertions.Assertions;
import org.junit.Test;
import pl.koziolekweb.lottomat.totolotek.TotolotekMachine.TotolotekResultOfDraw;

/**
 * TODO write JAVADOC!!!
 * User: koziolek
 */
public class TotolotekMachineTest {

	@Test
	public void shouldSmokeTest() throws Exception {
		TotolotekMachine sut = new TotolotekMachine();

		TotolotekResultOfDraw pick = sut.pick();

		Assertions.assertThat(pick).isNotNull();

	}
}