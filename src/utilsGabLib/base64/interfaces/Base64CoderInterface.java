package utilsGabLib.base64.interfaces;

import java.io.UnsupportedEncodingException;

import utilsGabLib.encode.CharEncode;

public interface Base64CoderInterface {

	public String encode(String origen);
	public String encode(String origen,CharEncode encode) throws UnsupportedEncodingException;
	public String decode(String base64);
	public String decode(String base64,CharEncode encode) throws UnsupportedEncodingException;

}
