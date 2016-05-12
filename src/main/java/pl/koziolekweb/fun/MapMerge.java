package pl.koziolekweb.fun;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * TODO write JAVADOC!!!
 * User: koziolek
 */
public class MapMerge<K, V> implements BiFunction<Map<K, V>, Map<K, V>, Map<K, V>> {

	private final BiFunction<? super V, ? super V, ? extends V> merge;

	public MapMerge(BiFunction<? super V, ? super V, ? extends V> merge) {
		this.merge = merge;
	}

	@Override
	public Map<K, V> apply(Map<K, V> left, Map<K, V> right) {
		if (left.isEmpty())
			return new HashMap<>(right);
		if (right.isEmpty())
			return new HashMap<>(left);
		HashMap<K, V> newMap = new HashMap<>(right);
		left.entrySet().stream()
				.forEach(e -> newMap.merge(e.getKey(), e.getValue(), merge));

		return newMap;
	}
}
