package pl.koziolekweb.lottomat.machine;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * TODO write JAVADOC!!!
 * User: koziolek
 */
public abstract class Machine<T> {

	public T pick(Collection<T> input, int i) {

		List<T> list = new ArrayList<>(input);
		Collections.shuffle(list);

		return
				map(list.stream().limit(i).collect(Collectors.toList()));
	}

	protected abstract T map(List<T> drawn);
}
