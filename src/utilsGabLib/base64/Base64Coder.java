package utilsGabLib.base64;

import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.binary.Base64;

import utilsGabLib.exceptions.UtilsGabLibException;
import utilsGabLib.string.encode.CharEncode;

public abstract class Base64Coder {

	// Encodes
	public static String encode(String origen) {
		String base64Str = new String(primitivaEncodeBase64(origen.getBytes()));
		return base64Str;
	}

	public static String encode(byte[] bytes_origen) {
		String base64Str = new String(primitivaEncodeBase64(bytes_origen));
		return base64Str;
	}

	public static String encode(String origen, CharEncode encode)
			throws UtilsGabLibException {
		try {
			String elementStr = new String(
					primitivaEncodeBase64(origen.getBytes()), encode.toString());
			return elementStr;
		} catch (UnsupportedEncodingException e) {
			throw new UtilsGabLibException(e.getMessage(), e);
		}

	}

	// Decodes
	public static String decode(String base64) {
		String elementStr = new String(primitivaDecodeBase64(base64.getBytes()));
		return elementStr;
	}

	public static String decode(byte[] bytes_base64) {
		String elementStr = new String(primitivaDecodeBase64(bytes_base64));
		return elementStr;
	}

	public static String decode(String base64, CharEncode encode)
			throws UtilsGabLibException {
		try {
			String elementStr = new String(
					primitivaDecodeBase64(base64.getBytes()), encode.toString());
			return elementStr;
		} catch (UnsupportedEncodingException e) {
			throw new UtilsGabLibException(e.getMessage(), e);
		}
	}

	private static byte[] primitivaEncodeBase64(byte[] origen) {
		return Base64.encodeBase64(origen);
	}

	private static byte[] primitivaDecodeBase64(byte[] base64) {
		return Base64.decodeBase64(base64);
	}

}
