package pl.koziolekweb.lottomat.totolotek;

import com.google.common.collect.Lists;
import org.junit.Test;
import pl.koziolekweb.lottomat.totolotek.TotolotekMachine.TotolotekResultOfDraw;

import java.util.Collection;
import java.util.Collections;

/**
 * TODO write JAVADOC!!!
 * User: koziolek
 */
public class TotolotekResultOfDrawTest {

	@Test(expected = NullPointerException.class)
	public void shouldThrowsOnNullResult() throws Exception {
		TotolotekResultOfDraw sut = new TotolotekResultOfDraw(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowsOnEmptyResult() throws Exception {
		TotolotekResultOfDraw sut = new TotolotekResultOfDraw(Collections.emptyList());
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
		TotolotekResultOfDraw sut = new TotolotekResultOfDraw(elementsOf5);
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
		TotolotekResultOfDraw sut = new TotolotekResultOfDraw(elementsOf7);
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
		TotolotekResultOfDraw sut = new TotolotekResultOfDraw(elementsOf6);
	}
}