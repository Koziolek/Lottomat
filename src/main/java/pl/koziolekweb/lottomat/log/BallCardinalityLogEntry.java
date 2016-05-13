package pl.koziolekweb.lottomat.log;

import pl.koziolekweb.lottomat.totolotek.Ball;

/**
 * TODO write JAVADOC!!!
 * User: koziolek
 */
public class BallCardinalityLogEntry implements LogEntry<String> {

	private final String logLine;

	public BallCardinalityLogEntry(Ball ball, Integer cardinality) {
		StringBuilder sb = new StringBuilder();
		ball.new RawBallView().accept(sb::append);
		sb.append("=").append(cardinality);
		logLine = sb.toString();
	}

	@Override
	public String logLine() {
		return logLine;
	}
}
