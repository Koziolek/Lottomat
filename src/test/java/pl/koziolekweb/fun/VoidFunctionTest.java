package pl.koziolekweb.fun;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

/**
 * TODO write JAVADOC!!!
 * User: koziolek
 */
public class VoidFunctionTest {

	@Test
	public void shouldApplyVoidCallApply() throws Exception {
		VoidFunction<Object> voidFunction = spy(new VFAssert());

		Object o = new Object();
		Void apply = voidFunction.apply(o);

		assertThat(apply).isNull();

		verify(voidFunction, atLeastOnce()).applyVoid(o);
	}
}

class VFAssert implements VoidFunction<Object> {


	@Override
	public void applyVoid(Object o) {

	}
}