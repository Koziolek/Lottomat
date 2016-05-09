package pl.koziolekweb.fun;

import java.util.function.Function;

@FunctionalInterface
public interface VoidFunction<T> extends Function<T, Void> {

	void applyVoid(T t);

	@Override
	default Void apply(T t) {
		applyVoid(t);
		return null;
	}
}
