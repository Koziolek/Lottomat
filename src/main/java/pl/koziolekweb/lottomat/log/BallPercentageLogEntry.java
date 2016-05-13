package pl.koziolekweb.lottomat.log;

import pl.koziolekweb.lottomat.totolotek.Ball;

import java.util.Locale;

import static java.lang.String.format;

/**
 * TODO write JAVADOC!!!
 * User: koziolek
 */
public class BallPercentageLogEntry implements LogEntry<String> {

	private final String logLine;

	public BallPercentageLogEntry(Ball ball, Integer cardinality, Integer all) {
		StringBuilder sb = new StringBuilder();
		ball.new RawBallView().accept(sb::append);
		sb.append("=").append(
				format(
						Locale.US,
						"%.2f",
						((cardinality * 100.) / all)
				)
		).append("%");
		logLine = sb.toString();
	}

	@Override
	public String logLine() {
		return logLine;
	}
}
