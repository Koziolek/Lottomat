package pl.koziolekweb.fun;

import java.util.Comparator;
import java.util.Map.Entry;

/**
 * TODO write JAVADOC!!!
 * User: koziolek
 */
public class MapByValueSortComparator<K, V> implements Comparator<Entry<K, V>> {


	private final Comparator<V> valueComparator;

	public MapByValueSortComparator(Comparator<V> valueComparator) {
		this.valueComparator = valueComparator;
	}

	@Override
	public int compare(Entry<K, V> o1, Entry<K, V> o2) {
		return valueComparator.compare(o1.getValue(), o2.getValue());
	}
}
