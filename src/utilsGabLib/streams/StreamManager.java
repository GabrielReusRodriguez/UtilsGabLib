package utilsGabLib.streams;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;

import utilsGabLib.encode.CharEncode;

public abstract class StreamManager {

	public static String stream2String(InputStream is) throws IOException {
		/*
		 * To convert the InputStream to String we use the Reader.read(char[]
		 * buffer) method. We iterate until the Reader return -1 which means
		 * there's no more data to read. We use the StringWriter class to
		 * produce the string.
		 */
		if (is != null) {
			Writer writer = new StringWriter();

			char[] buffer = new char[1024];

			try {
				// Reader reader = new BufferedReader(new InputStreamReader(is,
				// "ISO-8859-1"));
				Reader reader = new BufferedReader(new InputStreamReader(is));
				int n;
				while ((n = reader.read(buffer)) != -1) {
					writer.write(buffer, 0, n);
				}

			} finally {
				is.close();
			}
			return writer.toString();
		} else {
			return "";
		}
	}

	public static String stream2String(InputStream is, CharEncode encode)
			throws IOException {
		/*
		 * To convert the InputStream to String we use the Reader.read(char[]
		 * buffer) method. We iterate until the Reader return -1 which means
		 * there's no more data to read. We use the StringWriter class to
		 * produce the string.
		 */
		if (is != null) {
			Writer writer = new StringWriter();

			char[] buffer = new char[1024];

			try {
				Reader reader = new BufferedReader(new InputStreamReader(is,
						encode.toString()));
				int n;
				while ((n = reader.read(buffer)) != -1) {
					writer.write(buffer, 0, n);
				}

			} finally {
				is.close();
			}
			return writer.toString();
		} else {
			return "";
		}
	}

	public static InputStream string2Stream(String input,CharEncode encode) throws IOException {
		InputStream stream = new ByteArrayInputStream(input.getBytes(encode.toString()));
		return stream;
	}
}
