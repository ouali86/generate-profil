package cnav.gipur.pci.batch.utils;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

/**
 * 
 * @author ZEX9977
 *
 */
public class CSVUtils {
	private static final char DEFAULT_SEPARATOR = ';';

	public static void writeLine(OutputStreamWriter w, List<String> values) throws IOException {
		writeLine(w, values, DEFAULT_SEPARATOR, ' ');
	}

	public static void writeLine(OutputStreamWriter w, List<String> values, char separators) throws IOException {
		writeLine(w, values, separators, ' ');
	}

	// https://tools.ietf.org/html/rfc4180
	private static String followCVSformat(String value) {
		String result = value;
		if (result!=null && result.contains("\"")) {
			result = result.replace("\"", "\"\"");
		}
		return result;
	}

	public static void writeLine(OutputStreamWriter w, List<String> values, char separators, char customQuote) throws IOException {

		boolean first = true;

		// default customQuote is empty

		if (separators == ' ') {
			separators = DEFAULT_SEPARATOR;
		}

		StringBuilder sb = new StringBuilder();
		sb.append('\ufeff');
		for (String value : values) {
			if (!first) {
				sb.append(separators);
			}
			if (customQuote == ' ') {
				sb.append(followCVSformat(value));
			} else {
				sb.append(customQuote).append(followCVSformat(value)).append(customQuote);
			}

			first = false;
		}
		sb.append("\n");
		w.append(sb.toString());

	}

}