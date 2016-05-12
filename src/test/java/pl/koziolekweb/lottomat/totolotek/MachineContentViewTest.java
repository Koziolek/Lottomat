package pl.koziolekweb.lottomat.totolotek;

import org.junit.Test;
import pl.koziolekweb.lottomat.totolotek.TotolotekMachine.MachineContentView;

import java.util.Collection;
import java.util.function.Consumer;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Matchers.anyCollection;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * TODO write JAVADOC!!!
 * User: koziolek
 */
public class MachineContentViewTest {


	@Test
	public void shouldAcceptPassBallsCollectionToConsumer() throws Exception {
		TotolotekMachine machine = new TotolotekMachine();

		MachineContentView sut = machine.new MachineContentView();

		Consumer<Collection<Ball>> consumer = mock(Consumer.class);
		doAnswer(invocation ->
				assertThat((Collection<Ball>) invocation.getArguments()[0])
						.hasSize(49)
						.doesNotHaveDuplicates()
		)
				.when(consumer).accept(anyCollection());

		sut.accept(consumer);
		verify(consumer, atLeastOnce()).accept(anyCollection());

	}

}