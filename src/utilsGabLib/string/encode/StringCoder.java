package utilsGabLib.string.encode;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.text.translate.NumericEntityEscaper;

import utilsGabLib.exceptions.UtilsGabLibException;

public abstract class StringCoder {
	
	public static byte[] encode(String original,CharEncode encode) throws UtilsGabLibException{
		byte[] bytes = original.getBytes(encode.toCharset());
		return bytes;
	}
	public static String decode(byte[] original,CharEncode encode) throws UtilsGabLibException{
		String string = new String(original,encode.toCharset());
		return string;
	}
	
	public static String charsToXMLEntities(String s){
		String retorno ="";
		retorno = StringEscapeUtils.escapeXml(s);
		//Caracteres UTF8
		retorno = StringEscapeUtils.ESCAPE_XML.with( NumericEntityEscaper.between(0x7f, Integer.MAX_VALUE) ).translate(retorno);
		return retorno;
	}
	
	public static String xmlEntitiesToChars(String s){
		String retorno ="";
		retorno = StringEscapeUtils.unescapeXml(s);
		//Caracteres UTF8
		retorno = StringEscapeUtils.UNESCAPE_XML.with( NumericEntityEscaper.between(0x7f, Integer.MAX_VALUE) ).translate(retorno);
		return retorno;

	}

}
