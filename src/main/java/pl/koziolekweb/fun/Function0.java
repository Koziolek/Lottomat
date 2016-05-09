package pl.koziolekweb.fun;

import java.util.function.Function;

public interface Function0<R> extends Function<Void, R> {

	R apply();

	@Override
	default R apply(Void aVoid) {
		return apply();
	}
}
