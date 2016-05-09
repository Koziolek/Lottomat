package pl.koziolekweb.lottomat.machine;

import pl.koziolekweb.fun.Function0;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * TODO write JAVADOC!!!
 * User: koziolek
 */
public abstract class Machine<IN, T> {

	public T pick() {
		return getData()
				.andThen(defensiveCopy())
				.andThen(shuffle())
				.andThen(drawN())
				.andThen(mapToResult())
				.apply(null);
	}

	protected Function<Collection<IN>, List<IN>> defensiveCopy() {
		return ArrayList::new;
	}

	protected Function<List<IN>, List<IN>> shuffle() {
		return l -> {
			Collections.shuffle(l);
			return l;
		};
	}

	protected BiFunction<List<IN>, Integer, List<IN>> draw() {
		return (c, l) -> c.stream().limit(l).collect(Collectors.toList());
	}

	protected Function<List<IN>, List<IN>> drawN() {
		return l -> draw().apply(l, limit());
	}

	protected abstract Function0<Collection<IN>> getData();

	protected abstract Function<Collection<IN>, T> mapToResult();

	protected abstract Integer limit();


}
