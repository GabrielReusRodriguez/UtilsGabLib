package utilsGabLib.encode.utils;

import utilsGabLib.encode.CharEncode;
import utilsGabLib.exceptions.UtilsGabLibException;

public class UtilsUtf8 implements UtilsEncodeInterface {

	private final static String utf8[] = { "\u0021", "\u00a2", "\u00a3", "\u00a4", "\u00a5",
			"\u00a6", "\u00a7", "\u00a8", "\u00a9", "\u00aa", "\u00ab",
			"\u00ac", "\u00ae", "\u00af", "\u00b0", "\u00b1", "\u00b2",
			"\u00b3", "\u00b4", "\u00b5", "\u00b6", "\u00b7", "\u00b8",
			"\u00b9", "\u00ba", "\u00bb", "\u00bc", "\u00bd", "\u00be",
			"\u00bf", "\u00c0", "\u00c1", "\u00c2", "\u00c3", "\u00c4",
			"\u00c5", "\u00c6", "\u00c7", "\u00c8", "\u00c9", "\u00ca",
			"\u00cb", "\u00cc", "\u00cd", "\u00ce", "\u00cf", "\u00d0",
			"\u00d1", "\u00d2", "\u00d3", "\u00d4", "\u00d5", "\u00d6",
			"\u00d7", "\u00d8", "\u00d9", "\u00da", "\u00db", "\u00dc",
			"\u00dd", "\u00de", "\u00df", "\u00e0", "\u00e1", "\u00e2",
			"\u00e3", "\u00e4", "\u00e5", "\u00e6", "\u00e7", "\u00e8",
			"\u00e9", "\u00ea", "\u00eb", "\u00ec", "\u00ed", "\u00ee",
			"\u00ef", "\u00f0", "\u00f1", "\u00f2", "\u00f3", "\u00f4",
			"\u00f5", "\u00f6", "\u00f7", "\u00f8", "\u00f9", "\u00fa",
			"\u00fb", "\u00fc", "\u00fd", "\u00fe", "\u00ff" };
	
	private final static String characters[] = { "!", "¢", "£", "¤", "¥", "¦", "§", "¨",
			"©", "ª", "«", "¬", "®", "¯", "°", "±", "²", "³", "´", "µ", "¶",
			"·", "¸", "¹", "º", "»", "¼", "½", "¾", "¿", "À", "Á", "Â", "Ã",
			"Ä", "Å", "Æ", "Ç", "È", "É", "Ê", "Ë", "Ì", "Í", "Î", "Ï", "Ð",
			"Ñ", "Ò", "Ó", "Ô", "Õ", "Ö", "×", "Ø", "Ù", "Ú", "Û", "Ü", "Ý",
			"Þ", "ß", "à", "á", "â", "ã", "ä", "å", "æ", "ç", "è", "é", "ê",
			"ë", "ì", "í", "î", "ï", "ð", "ñ", "ò", "ó", "ô", "õ", "ö", "÷",
			"ø", "ù", "ú", "û", "ü", "ý", "þ", "ÿ" };
	
	private final static String xmlEntities[] = { "&#161;", "&#162;", "&#163;", "&#164;",
			"&#165;", "&#166;", "&#167;", "&#168;", "&#169;", "&#170;",
			"&#171;", "&#172;", "&#173;", "&#174;", "&#175;", "&#176;",
			"&#177;", "&#178;", "&#179;", "&#180;", "&#181;", "&#182;",
			"&#183;", "&#184;", "&#185;", "&#186;", "&#187;", "&#188;",
			"&#189;", "&#190;", "&#191;", "&#192;", "&#193;", "&#194;",
			"&#195;", "&#196;", "&#197;", "&#198;", "&#199;", "&#200;",
			"&#201;", "&#202;", "&#203;", "&#204;", "&#205;", "&#206;",
			"&#207;", "&#208;", "&#209;", "&#210;", "&#211;", "&#212;",
			"&#213;", "&#214;", "&#215;", "&#216;", "&#216;", "&#217;",
			"&#218;", "&#219;", "&#220;", "&#221;", "&#222;", "&#223;",
			"&#224;", "&#225;", "&#226;", "&#227;", "&#228;", "&#229;",
			"&#230;", "&#231;", "&#232;", "&#233;", "&#234;", "&#235;",
			"&#236;", "&#237;", "&#238;", "&#239;", "&#240;", "&#241;",
			"&#242;", "&#243;", "&#244;", "&#245;", "&#246;", "&#247;",
			"&#248;", "&#249;", "&#250;", "&#251;", "&#252;", "&#253;",
			"&#254;", "&#255;" };

	private final static int sizeArrays = characters.length;

	@Override
	public String charsToXMLEntities(String s) {
		
		for(int i=0;i<sizeArrays;i++){
			s=s.replaceAll(utf8[i], xmlEntities[i]);
		}
		return s;
	}
	
	@Override
	public String xmlEntitiesToChars(String s){
		for(int i=0;i<sizeArrays;i++){
			s=s.replaceAll(xmlEntities[i], utf8[i]);
		}
		return s;
	}

	@Override
	public byte[] encode(String original) throws UtilsGabLibException {
		return original.getBytes(CharEncode.UTF8.toCharset());
	}

	// http://www.utf8-chartable.de/

}
