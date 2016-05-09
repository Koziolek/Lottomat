package pl.koziolekweb.lottomat.machine;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * TODO write JAVADOC!!!
 * User: koziolek
 */
public abstract class Machine<T> {

	public T pick(Collection<T> input, int i) {
		return
				map(input.stream().limit(i).collect(Collectors.toList()));
	}

	protected abstract T map(List<T> drawn);
}
