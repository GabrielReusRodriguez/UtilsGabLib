package utilsGabLib.base64.impl;

import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.binary.Base64;

import utilsGabLib.base64.interfaces.Base64CoderInterface;
import utilsGabLib.encode.CharEncode;

public class Base64Coder implements Base64CoderInterface {

	public Base64Coder() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String encode(String origen) {
		String base64Str = new String(primitivaEncodeBase64(origen.getBytes()));
		return base64Str;
	}

	@Override
	public String decode(String base64) {
		String elementStr = new String(primitivaDecodeBase64(base64.getBytes()));
		return elementStr;
	}

	@Override
	public String decode(String base64, CharEncode encode)
			throws UnsupportedEncodingException {
		String elementStr = new String(
				primitivaDecodeBase64(base64.getBytes()), encode.toString());
		return elementStr;
	}

	private byte[] primitivaEncodeBase64(byte[] origen) {
		return Base64.encodeBase64(origen);
	}

	private byte[] primitivaDecodeBase64(byte[] base64) {
		return Base64.decodeBase64(base64);
	}

	@Override
	public String encode(String origen, CharEncode encode)
			throws UnsupportedEncodingException {
		String elementStr = new String(
				primitivaEncodeBase64(origen.getBytes()), encode.toString());
		return elementStr;
	}

}
