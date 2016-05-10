package pl.koziolekweb.lottomat.totolotek;

import com.google.common.collect.Lists;
import org.junit.Test;
import pl.koziolekweb.lottomat.totolotek.TotolotekMachine.TotolotekResults;

import java.util.Collection;
import java.util.Collections;

/**
 * TODO write JAVADOC!!!
 * User: koziolek
 */
public class TotolotekResultsTest {

	@Test(expected = NullPointerException.class)
	public void shouldThrowsOnNullResult() throws Exception {
		TotolotekResults sut = new TotolotekResults(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowsOnEmptyResult() throws Exception {
		TotolotekResults sut = new TotolotekResults(Collections.emptyList());
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowsOnLT6Result() throws Exception {
		Collection<Ball> elementsOf5 = Lists.newArrayList(
				new Ball(1),
				new Ball(2),
				new Ball(3),
				new Ball(4),
				new Ball(5)
		);
		TotolotekResults sut = new TotolotekResults(elementsOf5);
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowsOnGT6Result() throws Exception {
		Collection<Ball> elementsOf7 = Lists.newArrayList(
				new Ball(1),
				new Ball(2),
				new Ball(3),
				new Ball(4),
				new Ball(5),
				new Ball(6),
				new Ball(7)
		);
		TotolotekResults sut = new TotolotekResults(elementsOf7);
	}

	@Test
	public void shouldCreateWhen6InResult() throws Exception {
		Collection<Ball> elementsOf6 = Lists.newArrayList(
				new Ball(1),
				new Ball(2),
				new Ball(3),
				new Ball(4),
				new Ball(5),
				new Ball(6)
		);
		TotolotekResults sut = new TotolotekResults(elementsOf6);
	}
}