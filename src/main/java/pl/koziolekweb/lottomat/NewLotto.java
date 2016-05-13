package pl.koziolekweb.lottomat;

import pl.koziolekweb.fun.MapByValueSortComparator;
import pl.koziolekweb.lottomat.log.BallPercentageLogEntry;
import pl.koziolekweb.lottomat.log.StatisticLogger;
import pl.koziolekweb.lottomat.statistic.Statistic;
import pl.koziolekweb.lottomat.statistic.Statistic.StatisticBuilder;
import pl.koziolekweb.lottomat.totolotek.TotolotekMachine;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;
import static java.util.stream.Stream.generate;
import static pl.koziolekweb.lottomat.statistic.Statistic.StatisticBuilder.statistic;

/**
 * TODO write JAVADOC!!!
 * User: koziolek
 */
public class NewLotto {

	public static final int NBR = Lotto.NBR;

	public static void main(String[] args) {
		NewLotto newLotto = new NewLotto();
		Statistic reduce = newLotto.stat(NBR);

		reduce.new RawStatisticView().accept(new StatisticLogger<String>(
				System.out::println,
				es -> es.sorted(new MapByValueSortComparator<>(Integer::compare))
						.map(e -> new BallPercentageLogEntry(e.getKey(), e.getValue(), NBR))
		));
	}

	private final TotolotekMachine machine;

	public Statistic stat(int nbr) {
		Statistic initialStatistic = buildInitialStatistic();
		return generate(machine::pick)
				.limit(nbr)
				.reduce(initialStatistic, Statistic::append, Statistic::append);
	}

	private Statistic buildInitialStatistic() {
		StatisticBuilder builder = statistic();
		machine.new MachineContentView().accept(balls ->
				builder.withResults(balls.stream()
						.collect(toMap(identity(), b -> 0)))
		);
		return builder.build();
	}

	public NewLotto() {
		machine = new TotolotekMachine();
	}
}
