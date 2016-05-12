package pl.koziolekweb.lottomat.statistic;

import pl.koziolekweb.lottomat.totolotek.Ball;
import pl.koziolekweb.lottomat.totolotek.TotolotekMachine.TotolotekResultOfDraw;
import pl.koziolekweb.lottomat.totolotek.TotolotekMachine.TotolotekResultOfDraw.RawTotolotekResultOfDrawView;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * TODO write JAVADOC!!!
 * User: koziolek
 */
public class TotolotekResultToMap implements Function<TotolotekResultOfDraw, Map<Ball, Integer>> {
	@Override
	public Map<Ball, Integer> apply(TotolotekResultOfDraw draw) {
		RawTotolotekResultOfDrawView drawView = draw.new RawTotolotekResultOfDrawView();
		HashMap<Ball, Integer> map = new HashMap<>(6);
		drawView.accept(c -> c.forEach(b -> map.put(b, 1)));
		return map;
	}
}
