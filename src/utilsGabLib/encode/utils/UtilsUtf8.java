package utilsGabLib.encode.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;

public class UtilsUtf8 {

	/*
	 * 
	 * s.replaceAll("\u00b0","&#176;"); // ° degree sign s =
	 * s.replaceAll("\u00b1","&#177;"); // ± plus-or-minus sign s =
	 * s.replaceAll("\u00b2","&#178;"); // ² superscript two s =
	 * s.replaceAll("\u00b3","&#179;"); // ³ superscript three s =
	 * s.replaceAll("\u00b4","&#180;"); // ´ acute accent s =
	 * s.replaceAll("\u00b5","&#181;"); // µ micro sign s =
	 * s.replaceAll("\u00b6","&#182;"); // ¶ pilcrow (paragraph sign) s =
	 * s.replaceAll("\u00b7","&#183;"); // · middle dot s =
	 * s.replaceAll("\u00b8","&#184;"); // ¸ cedilla s =
	 * s.replaceAll("\u00b9","&#185;"); // ¹ superscript one s =
	 * s.replaceAll("\u00ba","&#186;"); // º ordinal indicator, masculine s =
	 * s.replaceAll("\u00bb","&#187;"); // » angle quotation mark, right s =
	 * s.replaceAll("\u00bc","&#188;"); // ¼ fraction one-quarter s =
	 * s.replaceAll("\u00bd","&#189;"); // ½ fraction one-half s =
	 * s.replaceAll("\u00be","&#190;"); // ¾ fraction three-quarters s =
	 * s.replaceAll("\u00bf","&#191;"); // ¿ inverted question mark s =
	 * s.replaceAll("\u00c0","&#192;"); // À capital A, grave accent s =
	 * s.replaceAll("\u00c1","&#193;"); // Á capital A, acute accent s =
	 * s.replaceAll("\u00c2","&#194;"); // Â capital A, circumflex accent s =
	 * s.replaceAll("\u00c3","&#195;"); // Ã capital A, tilde Ä => capital s =
	 * s.replaceAll("\u00c4","&#196;"); // Ä capital A, dieresis or umlaut mark
	 * s = s.replaceAll("\u00c5","&#197;"); // Å capital A, ring s =
	 * s.replaceAll("\u00c6","&#198;"); // Æ capital AE diphthong (ligature) s =
	 * s.replaceAll("\u00c7","&#199;"); // Ç capital C, cedilla s =
	 * s.replaceAll("\u00c8","&#200;"); // È capital E, grave accent s =
	 * s.replaceAll("\u00c9","&#201;"); // É capital E, acute accent s =
	 * s.replaceAll("\u00ca","&#202;"); // Ê capital E, circumflex accent s =
	 * s.replaceAll("\u00cb","&#203;"); // Ë capital E, dieresis or umlaut mark
	 * s = s.replaceAll("\u00cc","&#204;"); // Ì capital I, grave accent s =
	 * s.replaceAll("\u00cd","&#205;"); // Í capital I, acute accent s =
	 * s.replaceAll("\u00ce","&#206;"); // Î capital I, circumflex accent s =
	 * s.replaceAll("\u00cf","&#207;"); // Ï capital I, dieresis or umlaut mark
	 * s = s.replaceAll("\u00d0","&#208;"); // Ð capital Eth, Icelandic s =
	 * s.replaceAll("\u00d1","&#209;"); // Ñ capital N, tilde s =
	 * s.replaceAll("\u00d2","&#210;"); // Ò capital O, grave accent s =
	 * s.replaceAll("\u00d3","&#211;"); // Ó capital O, acute accent s =
	 * s.replaceAll("\u00d4","&#212;"); // Ô capital O, circumflex accent s =
	 * s.replaceAll("\u00d5","&#213;"); // Õ capital O, tilde s =
	 * s.replaceAll("\u00d6","&#214;"); // Ö capital O, dieresis or umlaut mark
	 * s = s.replaceAll("\u00d7","&#215;"); // × multiply sign s =
	 * s.replaceAll("\u00d8","&#216;"); // Ø capital O, slash s =
	 * s.replaceAll("\u00d9","&#217;"); // Ù capital U, grave accent s =
	 * s.replaceAll("\u00da","&#218;"); // Ú capital U, acute accent s =
	 * s.replaceAll("\u00db","&#219;"); // Û capital U, circumflex accent s =
	 * s.replaceAll("\u00dc","&#220;"); // Ü capital U, dieresis or umlaut mark
	 * s = s.replaceAll("\u00dd","&#221;"); // Ý capital Y, acute accent s =
	 * s.replaceAll("\u00de","&#222;"); // Þ capital THORN, Icelandic s =
	 * s.replaceAll("\u00df","&#223;"); // ß small sharp s, German (sz ligature)
	 * s = s.replaceAll("\u00e0","&#224;"); // à small a, grave accent s =
	 * s.replaceAll("\u00e1","&#225;"); // á small a, acute accent s =
	 * s.replaceAll("\u00e2","&#226;"); // â small a, circumflex accent s =
	 * s.replaceAll("\u00e3","&#227;"); // ã small a, tilde s =
	 * s.replaceAll("\u00e4","&#228;"); // ä small a, dieresis or umlaut mark s
	 * = s.replaceAll("\u00e5","&#229;"); // å small a, ring s =
	 * s.replaceAll("\u00e6","&#230;"); // æ small ae diphthong (ligature) s =
	 * s.replaceAll("\u00e7","&#231;"); // ç small c, cedilla s =
	 * s.replaceAll("\u00e8","&#232;"); // è small e, grave accent s =
	 * s.replaceAll("\u00e9","&#233;"); // é small e, acute accent s =
	 * s.replaceAll("\u00ea","&#234;"); // ê small e, circumflex accent s =
	 * s.replaceAll("\u00eb","&#235;"); // ë small e, dieresis or umlaut mark s
	 * = s.replaceAll("\u00ec","&#236;"); // ì small i, grave accent s =
	 * s.replaceAll("\u00ed","&#237;"); // í small i, acute accent s =
	 * s.replaceAll("\u00ee","&#238;"); // î small i, circumflex accent s =
	 * s.replaceAll("\u00ef","&#239;"); // ï small i, dieresis or umlaut mark s
	 * = s.replaceAll("\u00f0","&#240;"); // ð small eth, Icelandic s =
	 * s.replaceAll("\u00f1","&#241;"); // ñ small n, tilde s =
	 * s.replaceAll("\u00f2","&#242;"); // ò small o, grave accent s =
	 * s.replaceAll("\u00f3","&#243;"); // ó small o, acute accent s =
	 * s.replaceAll("\u00f4","&#244;"); // ô small o, circumflex accent s =
	 * s.replaceAll("\u00f5","&#245;"); // õ small o, tilde s =
	 * s.replaceAll("\u00f6","&#246;"); // ö small o, dieresis or umlaut mark s
	 * = s.replaceAll("\u00f7","&#247;"); // ÷ divide sign s =
	 * s.replaceAll("\u00f8","&#248;"); // ø small o, slash s =
	 * s.replaceAll("\u00f9","&#249;"); // ù small u, grave accent s =
	 * s.replaceAll("\u00fa","&#250;"); // ú small u, acute accent s =
	 * s.replaceAll("\u00fb","&#251;"); // û small u, circumflex accent s =
	 * s.replaceAll("\u00fc","&#252;"); // ü small u, dieresis or umlaut mark s
	 * = s.replaceAll("\u00fd","&#253;"); // ý small y, acute accent s =
	 * s.replaceAll("\u00fe","&#254;"); // þ small thorn, s =
	 * s.replaceAll("\u00ff","&#255;"); //" ÿ Icelandic ÿendif.
	 */

	private String utf8[] = { "\u0021", "\u00a2", "\u00a3", "\u00a4", "\u00a5",
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
	private String characters[] = { "!", "¢", "£", "¤", "¥", "¦", "§", "¨",
			"©", "ª", "«", "¬", "®", "¯","°", };
	private String xmlEntities[] = { "&#161;", "&#162;", "&#163;", "&#164;",
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

	public static String convertStreamToString(InputStream is)
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

	public static String convertStreamToString(InputStream is, String encode)
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
						encode));
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

	public static String undoReplaceNoUTF8(String s) {
		/*
		 * s = s.replaceAll("&amp;","&"); // s = s.replaceAll("&lt;","<"); // s
		 * = s.replaceAll("&gt;",">"); // s = s.replaceAll("&quot;","\""); // s
		 * = s.replaceAll("&apos;","'"); // s = s.replaceAll("&lt;","<"); // s =
		 * s.replaceAll("&gt;",">");
		 */
		s = s.replaceAll("&#161;", "¡"); // inverted exclamation mark
		s = s.replaceAll("&#162;", "¢"); // cent sign
		s = s.replaceAll("&#163;", "£"); // pound sterling sign
		s = s.replaceAll("&#164;", "¤"); // general currency sign
		s = s.replaceAll("&#165;", "¥"); // yen sign
		s = s.replaceAll("&#166;", "¦"); // broken (vertical) bar
		s = s.replaceAll("&#167;", "§"); // section sign
		s = s.replaceAll("&#168;", "¨"); // umlaut (dieresis)
		s = s.replaceAll("&#169;", "©"); // copyright sign
		s = s.replaceAll("&#170;", "ª"); // ordinal indicator, feminine
		s = s.replaceAll("&#171;", "«"); // angle quotation mark, left
		s = s.replaceAll("&#172;", "¬"); // not sign ­
											// soft hyphen
		s = s.replaceAll("&#174;", "®"); // registered sign
		s = s.replaceAll("&#175;", "¯"); // macron
		s = s.replaceAll("&#176;", "°"); // degree sign
		s = s.replaceAll("&#177;", "±"); // plus-or-minus sign
		s = s.replaceAll("&#178;", "²"); // superscript two
		s = s.replaceAll("&#179;", "³"); // superscript three
		s = s.replaceAll("&#180;", "´"); // acute accent
		s = s.replaceAll("&#181;", "µ"); // micro sign
		s = s.replaceAll("&#182;", "¶"); // pilcrow (paragraph sign)
		s = s.replaceAll("&#183;", "·"); // middle dot
		s = s.replaceAll("&#184;", "¸"); // cedilla
		s = s.replaceAll("&#185;", "¹"); // superscript one
		s = s.replaceAll("&#186;", "º"); // ordinal indicator, masculine
		s = s.replaceAll("&#187;", "»"); // angle quotation mark, right
		s = s.replaceAll("&#188;", "¼"); // fraction one-quarter
		s = s.replaceAll("&#189;", "½"); // fraction one-half
		s = s.replaceAll("&#190;", "¾"); // fraction three-quarters
		s = s.replaceAll("&#191;", "¿"); // inverted question mark
		s = s.replaceAll("&#192;", "À"); // capital A, grave accent
		s = s.replaceAll("&#193;", "Á"); // capital A, acute accent
		s = s.replaceAll("&#194;", "Â"); // capital A, circumflex accent
		s = s.replaceAll("&#195;", "Ã"); // capital A, tilde Ä => capital
		s = s.replaceAll("&#196;", "Ä"); // capital A, dieresis or umlaut mark
		s = s.replaceAll("&#197;", "Å"); // capital A, ring
		s = s.replaceAll("&#198;", "Æ"); // capital AE diphthong (ligature)
		s = s.replaceAll("&#199;", "Ç"); // capital C, cedilla
		s = s.replaceAll("&#200;", "È"); // capital E, grave accent
		s = s.replaceAll("&#201;", "É"); // capital E, acute accent
		s = s.replaceAll("&#202;", "Ê"); // capital E, circumflex accent
		s = s.replaceAll("&#203;", "Ë"); // capital E, dieresis or umlaut mark
		s = s.replaceAll("&#204;", "Ì"); // capital I, grave accent
		s = s.replaceAll("&#205;", "Í"); // capital I, acute accent
		s = s.replaceAll("&#206;", "Î"); // capital I, circumflex accent
		s = s.replaceAll("&#207;", "Ï"); // capital I, dieresis or umlaut mark
		s = s.replaceAll("&#208;", "Ð"); // capital Eth, Icelandic
		s = s.replaceAll("&#209;", "Ñ"); // capital N, tilde
		s = s.replaceAll("&#210;", "Ò"); // capital O, grave accent
		s = s.replaceAll("&#211;", "Ó"); // capital O, acute accent
		s = s.replaceAll("&#212;", "Ô"); // capital O, circumflex accent
		s = s.replaceAll("&#213;", "Õ"); // capital O, tilde
		s = s.replaceAll("&#214;", "Ö"); // capital O, dieresis or umlaut mark
		s = s.replaceAll("&#215;", "×"); // multiply sign
		s = s.replaceAll("&#216;", "Ø"); // capital O, slash
		s = s.replaceAll("&#217;", "Ù"); // capital U, grave accent
		s = s.replaceAll("&#218;", "Ú"); // capital U, acute accent
		s = s.replaceAll("&#219;", "Û"); // capital U, circumflex accent
		s = s.replaceAll("&#220;", "Ü"); // capital U, dieresis or umlaut mark
		s = s.replaceAll("&#221;", "Ý"); // capital Y, acute accent
		s = s.replaceAll("&#222;", "Þ"); // capital THORN, Icelandic
		s = s.replaceAll("&#223;", "ß"); // small sharp s, German (sz ligature)
		s = s.replaceAll("&#224;", "à"); // small a, grave accent
		s = s.replaceAll("&#225;", "á"); // small a, acute accent
		s = s.replaceAll("&#226;", "â"); // small a, circumflex accent
		s = s.replaceAll("&#227;", "ã"); // small a, tilde
		s = s.replaceAll("&#228;", "ä"); // small a, dieresis or umlaut mark
		s = s.replaceAll("&#229;", "å"); // small a, ring
		s = s.replaceAll("&#230;", "æ"); // small ae diphthong (ligature)
		s = s.replaceAll("&#231;", "ç"); // small c, cedilla
		s = s.replaceAll("&#232;", "è"); // small e, grave accent
		s = s.replaceAll("&#233;", "é"); // small e, acute accent
		s = s.replaceAll("&#234;", "ê"); // small e, circumflex accent
		s = s.replaceAll("&#235;", "ë"); // small e, dieresis or umlaut mark
		s = s.replaceAll("&#236;", "ì"); // small i, grave accent
		s = s.replaceAll("&#237;", "í"); // small i, acute accent
		s = s.replaceAll("&#238;", "î"); // small i, circumflex accent
		s = s.replaceAll("&#239;", "ï"); // small i, dieresis or umlaut mark
		s = s.replaceAll("&#240;", "ð"); // small eth, Icelandic
		s = s.replaceAll("&#241;", "ñ"); // small n, tilde
		s = s.replaceAll("&#242;", "ò"); // small o, grave accent
		s = s.replaceAll("&#243;", "ó"); // small o, acute accent
		s = s.replaceAll("&#244;", "ô"); // small o, circumflex accent
		s = s.replaceAll("&#245;", "õ"); // small o, tilde
		s = s.replaceAll("&#246;", "ö"); // small o, dieresis or umlaut mark
		s = s.replaceAll("&#247;", "÷"); // divide sign
		s = s.replaceAll("&#248;", "ø"); // small o, slash
		s = s.replaceAll("&#249;", "ù"); // small u, grave accent
		s = s.replaceAll("&#250;", "ú"); // small u, acute accent
		s = s.replaceAll("&#251;", "û"); // small u, circumflex accent
		s = s.replaceAll("&#252;", "ü"); // small u, dieresis or umlaut mark
		s = s.replaceAll("&#253;", "ý"); // small y, acute accent
		s = s.replaceAll("&#254;", "þ"); // small thorn,
		s = s.replaceAll("&#255;", "ÿ"); // "Icelandic ÿendif.

		return s;
	}

	public static String replaceNoUTF8(String s) {
		/*
		 * s = s.replaceAll("&","&amp;"); s = s.replaceAll("<", "&lt;"); s =
		 * s.replaceAll(">", "&gt;"); s = s.replaceAll("ns1:", ""); s =
		 * s.replaceAll("\"","&quot;"); s = s.replaceAll("'","&apos;"); s =
		 * s.replaceAll(":ns1", ""); s = s.replaceAll("&","&amp;"); s =
		 * s.replaceAll("<", "&lt;"); s = s.replaceAll(">", "&gt;"); s =
		 * s.replaceAll("ns0:", ""); s = s.replaceAll("\"","&quot;"); s =
		 * s.replaceAll("'","&apos;"); s = s.replaceAll(":ns0", "");
		 */
		s = s.replaceAll("¡", "&#161;"); // inverted exclamation mark
		s = s.replaceAll("¢", "&#162;"); // cent sign
		s = s.replaceAll("£", "&#163;"); // pound sterling sign
		s = s.replaceAll("¤", "&#164;"); // general currency sign
		s = s.replaceAll("¥", "&#165;"); // yen sign
		s = s.replaceAll("¦", "&#166;"); // broken (vertical) bar
		s = s.replaceAll("§", "&#167;"); // section sign
		s = s.replaceAll("¨", "&#168;"); // umlaut (dieresis)
		s = s.replaceAll("©", "&#169;"); // copyright sign
		s = s.replaceAll("ª", "&#170;"); // ordinal indicator, feminine
		s = s.replaceAll("«", "&#171;"); // angle quotation mark, left
		s = s.replaceAll("¬", "&#172;"); // not sign ­
											// soft hyphen
		s = s.replaceAll("®", "&#174;"); // registered sign
		s = s.replaceAll("¯", "&#175;"); // macron
		s = s.replaceAll("°", "&#176;"); // degree sign
		s = s.replaceAll("±", "&#177;"); // plus-or-minus sign
		s = s.replaceAll("²", "&#178;"); // superscript two
		s = s.replaceAll("³", "&#179;"); // superscript three
		s = s.replaceAll("´", "&#180;"); // acute accent
		s = s.replaceAll("µ", "&#181;"); // micro sign
		s = s.replaceAll("¶", "&#182;"); // pilcrow (paragraph sign)
		s = s.replaceAll("·", "&#183;"); // middle dot
		s = s.replaceAll("¸", "&#184;"); // cedilla
		s = s.replaceAll("¹", "&#185;"); // superscript one
		s = s.replaceAll("º", "&#186;"); // ordinal indicator, masculine
		s = s.replaceAll("»", "&#187;"); // angle quotation mark, right
		s = s.replaceAll("¼", "&#188;"); // fraction one-quarter
		s = s.replaceAll("½", "&#189;"); // fraction one-half
		s = s.replaceAll("¾", "&#190;"); // fraction three-quarters
		s = s.replaceAll("¿", "&#191;"); // inverted question mark
		s = s.replaceAll("À", "&#192;"); // capital A, grave accent
		s = s.replaceAll("Á", "&#193;"); // capital A, acute accent
		s = s.replaceAll("Â", "&#194;"); // capital A, circumflex accent
		s = s.replaceAll("Ã", "&#195;"); // capital A, tilde Ä => capital
		s = s.replaceAll("Ä", "&#196;"); // capital A, dieresis or umlaut mark
		s = s.replaceAll("Å", "&#197;"); // capital A, ring
		s = s.replaceAll("Æ", "&#198;"); // capital AE diphthong (ligature)
		s = s.replaceAll("Ç", "&#199;"); // capital C, cedilla
		s = s.replaceAll("È", "&#200;"); // capital E, grave accent
		s = s.replaceAll("É", "&#201;"); // capital E, acute accent
		s = s.replaceAll("Ê", "&#202;"); // capital E, circumflex accent
		s = s.replaceAll("Ë", "&#203;"); // capital E, dieresis or umlaut mark
		s = s.replaceAll("Ì", "&#204;"); // capital I, grave accent
		s = s.replaceAll("Í", "&#205;"); // capital I, acute accent
		s = s.replaceAll("Î", "&#206;"); // capital I, circumflex accent
		s = s.replaceAll("Ï", "&#207;"); // capital I, dieresis or umlaut mark
		s = s.replaceAll("Ð", "&#208;"); // capital Eth, Icelandic
		s = s.replaceAll("Ñ", "&#209;"); // capital N, tilde
		s = s.replaceAll("Ò", "&#210;"); // capital O, grave accent
		s = s.replaceAll("Ó", "&#211;"); // capital O, acute accent
		s = s.replaceAll("Ô", "&#212;"); // capital O, circumflex accent
		s = s.replaceAll("Õ", "&#213;"); // capital O, tilde
		s = s.replaceAll("Ö", "&#214;"); // capital O, dieresis or umlaut mark
		s = s.replaceAll("×", "&#215;"); // multiply sign
		s = s.replaceAll("Ø", "&#216;"); // capital O, slash
		s = s.replaceAll("Ù", "&#217;"); // capital U, grave accent
		s = s.replaceAll("Ú", "&#218;"); // capital U, acute accent
		s = s.replaceAll("Û", "&#219;"); // capital U, circumflex accent
		s = s.replaceAll("Ü", "&#220;"); // capital U, dieresis or umlaut mark
		s = s.replaceAll("Ý", "&#221;"); // capital Y, acute accent
		s = s.replaceAll("Þ", "&#222;"); // capital THORN, Icelandic
		s = s.replaceAll("ß", "&#223;"); // small sharp s, German (sz ligature)
		s = s.replaceAll("à", "&#224;"); // small a, grave accent
		s = s.replaceAll("á", "&#225;"); // small a, acute accent
		s = s.replaceAll("â", "&#226;"); // small a, circumflex accent
		s = s.replaceAll("ã", "&#227;"); // small a, tilde
		s = s.replaceAll("ä", "&#228;"); // small a, dieresis or umlaut mark
		s = s.replaceAll("å", "&#229;"); // small a, ring
		s = s.replaceAll("æ", "&#230;"); // small ae diphthong (ligature)
		s = s.replaceAll("ç", "&#231;"); // small c, cedilla
		s = s.replaceAll("è", "&#232;"); // small e, grave accent
		s = s.replaceAll("é", "&#233;"); // small e, acute accent
		s = s.replaceAll("ê", "&#234;"); // small e, circumflex accent
		s = s.replaceAll("ë", "&#235;"); // small e, dieresis or umlaut mark
		s = s.replaceAll("ì", "&#236;"); // small i, grave accent
		s = s.replaceAll("í", "&#237;"); // small i, acute accent
		s = s.replaceAll("î", "&#238;"); // small i, circumflex accent
		s = s.replaceAll("ï", "&#239;"); // small i, dieresis or umlaut mark
		s = s.replaceAll("ð", "&#240;"); // small eth, Icelandic
		s = s.replaceAll("ñ", "&#241;"); // small n, tilde
		s = s.replaceAll("ò", "&#242;"); // small o, grave accent
		s = s.replaceAll("ó", "&#243;"); // small o, acute accent
		s = s.replaceAll("ô", "&#244;"); // small o, circumflex accent
		s = s.replaceAll("õ", "&#245;"); // small o, tilde
		s = s.replaceAll("ö", "&#246;"); // small o, dieresis or umlaut mark
		s = s.replaceAll("÷", "&#247;"); // divide sign
		s = s.replaceAll("ø", "&#248;"); // small o, slash
		s = s.replaceAll("ù", "&#249;"); // small u, grave accent
		s = s.replaceAll("ú", "&#250;"); // small u, acute accent
		s = s.replaceAll("û", "&#251;"); // small u, circumflex accent
		s = s.replaceAll("ü", "&#252;"); // small u, dieresis or umlaut mark
		s = s.replaceAll("ý", "&#253;"); // small y, acute accent
		s = s.replaceAll("þ", "&#254;"); // small thorn,
		s = s.replaceAll("ÿ", "&#255;"); // "Icelandic ÿendif.

		return s;
	}

	// http://www.utf8-chartable.de/
	public static String utf8CharsToXMLEntities(String s) {
		/*
		 * s = s.replaceAll("&","&amp;"); s = s.replaceAll("<", "&lt;"); s =
		 * s.replaceAll(">", "&gt;"); s = s.replaceAll("ns1:", ""); s =
		 * s.replaceAll("\"","&quot;"); s = s.replaceAll("'","&apos;"); s =
		 * s.replaceAll(":ns1", ""); s = s.replaceAll("&","&amp;"); s =
		 * s.replaceAll("<", "&lt;"); s = s.replaceAll(">", "&gt;"); s =
		 * s.replaceAll("ns0:", ""); s = s.replaceAll("\"","&quot;"); s =
		 * s.replaceAll("'","&apos;"); s = s.replaceAll(":ns0", "");
		 */
		s = s.replaceAll("\u0021", "&#161;"); // ! inverted exclamation mark
		s = s.replaceAll("\u00a2", "&#162;"); // ¢ cent sign
		s = s.replaceAll("\u00a3", "&#163;"); // £ pound sterling sign
		s = s.replaceAll("\u00a4", "&#164;"); // ¤ general currency sign
		s = s.replaceAll("\u00a5", "&#165;"); // ¥ yen sign
		s = s.replaceAll("\u00a6", "&#166;"); // ¦ broken (vertical) bar
		s = s.replaceAll("\u00a7", "&#167;"); // § section sign
		s = s.replaceAll("\u00a8", "&#168;"); // ¨ umlaut (dieresis)
		s = s.replaceAll("\u00a9", "&#169;"); // © copyright sign
		s = s.replaceAll("\u00aa", "&#170;"); // ª ordinal indicator, feminine
		s = s.replaceAll("\u00ab", "&#171;"); // « angle quotation mark, left
		s = s.replaceAll("\u00ac", "&#172;"); // ¬ not sign ­
		s = s.replaceAll("\u00ae", "&#174;"); // ® registered sign
		s = s.replaceAll("\u00af", "&#175;"); // ¯ macron
		s = s.replaceAll("\u00b0", "&#176;"); // ° degree sign
		s = s.replaceAll("\u00b1", "&#177;"); // ± plus-or-minus sign
		s = s.replaceAll("\u00b2", "&#178;"); // ² superscript two
		s = s.replaceAll("\u00b3", "&#179;"); // ³ superscript three
		s = s.replaceAll("\u00b4", "&#180;"); // ´ acute accent
		s = s.replaceAll("\u00b5", "&#181;"); // µ micro sign
		s = s.replaceAll("\u00b6", "&#182;"); // ¶ pilcrow (paragraph sign)
		s = s.replaceAll("\u00b7", "&#183;"); // · middle dot
		s = s.replaceAll("\u00b8", "&#184;"); // ¸ cedilla
		s = s.replaceAll("\u00b9", "&#185;"); // ¹ superscript one
		s = s.replaceAll("\u00ba", "&#186;"); // º ordinal indicator, masculine
		s = s.replaceAll("\u00bb", "&#187;"); // » angle quotation mark, right
		s = s.replaceAll("\u00bc", "&#188;"); // ¼ fraction one-quarter
		s = s.replaceAll("\u00bd", "&#189;"); // ½ fraction one-half
		s = s.replaceAll("\u00be", "&#190;"); // ¾ fraction three-quarters
		s = s.replaceAll("\u00bf", "&#191;"); // ¿ inverted question mark
		s = s.replaceAll("\u00c0", "&#192;"); // À capital A, grave accent
		s = s.replaceAll("\u00c1", "&#193;"); // Á capital A, acute accent
		s = s.replaceAll("\u00c2", "&#194;"); // Â capital A, circumflex accent
		s = s.replaceAll("\u00c3", "&#195;"); // Ã capital A, tilde Ä => capital
		s = s.replaceAll("\u00c4", "&#196;"); // Ä capital A, dieresis or umlaut
												// mark
		s = s.replaceAll("\u00c5", "&#197;"); // Å capital A, ring
		s = s.replaceAll("\u00c6", "&#198;"); // Æ capital AE diphthong
												// (ligature)
		s = s.replaceAll("\u00c7", "&#199;"); // Ç capital C, cedilla
		s = s.replaceAll("\u00c8", "&#200;"); // È capital E, grave accent
		s = s.replaceAll("\u00c9", "&#201;"); // É capital E, acute accent
		s = s.replaceAll("\u00ca", "&#202;"); // Ê capital E, circumflex accent
		s = s.replaceAll("\u00cb", "&#203;"); // Ë capital E, dieresis or umlaut
												// mark
		s = s.replaceAll("\u00cc", "&#204;"); // Ì capital I, grave accent
		s = s.replaceAll("\u00cd", "&#205;"); // Í capital I, acute accent
		s = s.replaceAll("\u00ce", "&#206;"); // Î capital I, circumflex accent
		s = s.replaceAll("\u00cf", "&#207;"); // Ï capital I, dieresis or umlaut
												// mark
		s = s.replaceAll("\u00d0", "&#208;"); // Ð capital Eth, Icelandic
		s = s.replaceAll("\u00d1", "&#209;"); // Ñ capital N, tilde
		s = s.replaceAll("\u00d2", "&#210;"); // Ò capital O, grave accent
		s = s.replaceAll("\u00d3", "&#211;"); // Ó capital O, acute accent
		s = s.replaceAll("\u00d4", "&#212;"); // Ô capital O, circumflex accent
		s = s.replaceAll("\u00d5", "&#213;"); // Õ capital O, tilde
		s = s.replaceAll("\u00d6", "&#214;"); // Ö capital O, dieresis or umlaut
												// mark
		s = s.replaceAll("\u00d7", "&#215;"); // × multiply sign
		s = s.replaceAll("\u00d8", "&#216;"); // Ø capital O, slash
		s = s.replaceAll("\u00d9", "&#217;"); // Ù capital U, grave accent
		s = s.replaceAll("\u00da", "&#218;"); // Ú capital U, acute accent
		s = s.replaceAll("\u00db", "&#219;"); // Û capital U, circumflex accent
		s = s.replaceAll("\u00dc", "&#220;"); // Ü capital U, dieresis or umlaut
												// mark
		s = s.replaceAll("\u00dd", "&#221;"); // Ý capital Y, acute accent
		s = s.replaceAll("\u00de", "&#222;"); // Þ capital THORN, Icelandic
		s = s.replaceAll("\u00df", "&#223;"); // ß small sharp s, German (sz
												// ligature)
		s = s.replaceAll("\u00e0", "&#224;"); // à small a, grave accent
		s = s.replaceAll("\u00e1", "&#225;"); // á small a, acute accent
		s = s.replaceAll("\u00e2", "&#226;"); // â small a, circumflex accent
		s = s.replaceAll("\u00e3", "&#227;"); // ã small a, tilde
		s = s.replaceAll("\u00e4", "&#228;"); // ä small a, dieresis or umlaut
												// mark
		s = s.replaceAll("\u00e5", "&#229;"); // å small a, ring
		s = s.replaceAll("\u00e6", "&#230;"); // æ small ae diphthong (ligature)
		s = s.replaceAll("\u00e7", "&#231;"); // ç small c, cedilla
		s = s.replaceAll("\u00e8", "&#232;"); // è small e, grave accent
		s = s.replaceAll("\u00e9", "&#233;"); // é small e, acute accent
		s = s.replaceAll("\u00ea", "&#234;"); // ê small e, circumflex accent
		s = s.replaceAll("\u00eb", "&#235;"); // ë small e, dieresis or umlaut
												// mark
		s = s.replaceAll("\u00ec", "&#236;"); // ì small i, grave accent
		s = s.replaceAll("\u00ed", "&#237;"); // í small i, acute accent
		s = s.replaceAll("\u00ee", "&#238;"); // î small i, circumflex accent
		s = s.replaceAll("\u00ef", "&#239;"); // ï small i, dieresis or umlaut
												// mark
		s = s.replaceAll("\u00f0", "&#240;"); // ð small eth, Icelandic
		s = s.replaceAll("\u00f1", "&#241;"); // ñ small n, tilde
		s = s.replaceAll("\u00f2", "&#242;"); // ò small o, grave accent
		s = s.replaceAll("\u00f3", "&#243;"); // ó small o, acute accent
		s = s.replaceAll("\u00f4", "&#244;"); // ô small o, circumflex accent
		s = s.replaceAll("\u00f5", "&#245;"); // õ small o, tilde
		s = s.replaceAll("\u00f6", "&#246;"); // ö small o, dieresis or umlaut
												// mark
		s = s.replaceAll("\u00f7", "&#247;"); // ÷ divide sign
		s = s.replaceAll("\u00f8", "&#248;"); // ø small o, slash
		s = s.replaceAll("\u00f9", "&#249;"); // ù small u, grave accent
		s = s.replaceAll("\u00fa", "&#250;"); // ú small u, acute accent
		s = s.replaceAll("\u00fb", "&#251;"); // û small u, circumflex accent
		s = s.replaceAll("\u00fc", "&#252;"); // ü small u, dieresis or umlaut
												// mark
		s = s.replaceAll("\u00fd", "&#253;"); // ý small y, acute accent
		s = s.replaceAll("\u00fe", "&#254;"); // þ small thorn,
		s = s.replaceAll("\u00ff", "&#255;"); // " ÿ Icelandic ÿendif.

		return s;
	}

	public static String xmlEntitiesToUtf8Char(String s) {
		/*
		 * s = s.replaceAll("&","&amp;"); s = s.replaceAll("<", "&lt;"); s =
		 * s.replaceAll(">", "&gt;"); s = s.replaceAll("ns1:", ""); s =
		 * s.replaceAll("\"","&quot;"); s = s.replaceAll("'","&apos;"); s =
		 * s.replaceAll(":ns1", ""); s = s.replaceAll("&","&amp;"); s =
		 * s.replaceAll("<", "&lt;"); s = s.replaceAll(">", "&gt;"); s =
		 * s.replaceAll("ns0:", ""); s = s.replaceAll("\"","&quot;"); s =
		 * s.replaceAll("'","&apos;"); s = s.replaceAll(":ns0", "");
		 */
		s = s.replaceAll("&#161;", "\u0021"); // ! inverted exclamation mark
		s = s.replaceAll("&#162;", "\u00a2"); // ¢ cent sign
		s = s.replaceAll("&#163;", "\u00a3"); // £ pound sterling sign
		s = s.replaceAll("&#164;", "\u00a4"); // ¤ general currency sign
		s = s.replaceAll("&#165;", "\u00a5"); // ¥ yen sign
		s = s.replaceAll("&#166;", "\u00a6"); // ¦ broken (vertical) bar
		s = s.replaceAll("&#167;", "\u00a7"); // § section sign
		s = s.replaceAll("&#168;", "\u00a8"); // ¨ umlaut (dieresis)
		s = s.replaceAll("&#169;", "\u00a9"); // © copyright sign
		s = s.replaceAll("&#170;", "\u00aa"); // ª ordinal indicator, feminine
		s = s.replaceAll("&#171;", "\u00ab"); // « angle quotation mark, left
		s = s.replaceAll("&#172;", "\u00ac"); // ¬ not sign ­
		s = s.replaceAll("&#174;", "\u00ae"); // ® registered sign
		s = s.replaceAll("&#175;", "\u00af"); // ¯ macron
		s = s.replaceAll("&#176;", "\u00b0"); // ° degree sign
		s = s.replaceAll("&#177;", "\u00b1"); // ± plus-or-minus sign
		s = s.replaceAll("&#178;", "\u00b2"); // ² superscript two
		s = s.replaceAll("&#179;", "\u00b3"); // ³ superscript three
		s = s.replaceAll("&#180;", "\u00b4"); // ´ acute accent
		s = s.replaceAll("&#181;", "\u00b5"); // µ micro sign
		s = s.replaceAll("&#182;", "\u00b6"); // ¶ pilcrow (paragraph sign)
		s = s.replaceAll("&#183;", "\u00b7"); // · middle dot
		s = s.replaceAll("&#184;", "\u00b8"); // ¸ cedilla
		s = s.replaceAll("&#185;", "\u00b9"); // ¹ superscript one
		s = s.replaceAll("&#186;", "\u00ba"); // º ordinal indicator, masculine
		s = s.replaceAll("&#187;", "\u00bb"); // » angle quotation mark, right
		s = s.replaceAll("&#188;", "\u00bc"); // ¼ fraction one-quarter
		s = s.replaceAll("&#189;", "\u00bd"); // ½ fraction one-half
		s = s.replaceAll("&#190;", "\u00be"); // ¾ fraction three-quarters
		s = s.replaceAll("&#191;", "\u00bf"); // ¿ inverted question mark
		s = s.replaceAll("&#192;", "\u00c0"); // À capital A, grave accent
		s = s.replaceAll("&#193;", "\u00c1"); // Á capital A, acute accent
		s = s.replaceAll("&#194;", "\u00c2"); // Â capital A, circumflex accent
		s = s.replaceAll("&#195;", "\u00c3"); // Ã capital A, tilde Ä => capital
		s = s.replaceAll("&#196;", "\u00c4"); // Ä capital A, dieresis or umlaut
												// mark
		s = s.replaceAll("&#197;", "\u00c5"); // Å capital A, ring
		s = s.replaceAll("&#198;", "\u00c6"); // Æ capital AE diphthong
												// (ligature)
		s = s.replaceAll("&#199;", "\u00c7"); // Ç capital C, cedilla
		s = s.replaceAll("&#200;", "\u00c8"); // È capital E, grave accent
		s = s.replaceAll("&#201;", "\u00c9"); // É capital E, acute accent
		s = s.replaceAll("&#202;", "\u00ca"); // Ê capital E, circumflex accent
		s = s.replaceAll("&#203;", "\u00cb"); // Ë capital E, dieresis or umlaut
												// mark
		s = s.replaceAll("&#204;", "\u00cc"); // Ì capital I, grave accent
		s = s.replaceAll("&#205;", "\u00cd"); // Í capital I, acute accent
		s = s.replaceAll("&#206;", "\u00ce"); // Î capital I, circumflex accent
		s = s.replaceAll("&#207;", "\u00cf"); // Ï capital I, dieresis or umlaut
												// mark
		s = s.replaceAll("&#208;", "\u00d0"); // Ð capital Eth, Icelandic
		s = s.replaceAll("&#209;", "\u00d1"); // Ñ capital N, tilde
		s = s.replaceAll("&#210;", "\u00d2"); // Ò capital O, grave accent
		s = s.replaceAll("&#211;", "\u00d3"); // Ó capital O, acute accent
		s = s.replaceAll("&#212;", "\u00d4"); // Ô capital O, circumflex accent
		s = s.replaceAll("&#213;", "\u00d5"); // Õ capital O, tilde
		s = s.replaceAll("&#214;", "\u00d6"); // Ö capital O, dieresis or umlaut
												// mark
		s = s.replaceAll("&#215;", "\u00d7"); // × multiply sign
		s = s.replaceAll("&#216;", "\u00d8"); // Ø capital O, slash
		s = s.replaceAll("&#217;", "\u00d9"); // Ù capital U, grave accent
		s = s.replaceAll("&#218;", "\u00da"); // Ú capital U, acute accent
		s = s.replaceAll("&#219;", "\u00db"); // Û capital U, circumflex accent
		s = s.replaceAll("&#220;", "\u00dc"); // Ü capital U, dieresis or umlaut
												// mark
		s = s.replaceAll("&#221;", "\u00dd"); // Ý capital Y, acute accent
		s = s.replaceAll("&#222;", "\u00de"); // Þ capital THORN, Icelandic
		s = s.replaceAll("&#223;", "\u00df"); // ß small sharp s, German (sz
												// ligature)
		s = s.replaceAll("&#224;", "\u00e0"); // à small a, grave accent
		s = s.replaceAll("&#225;", "\u00e1"); // á small a, acute accent
		s = s.replaceAll("&#226;", "\u00e2"); // â small a, circumflex accent
		s = s.replaceAll("&#227;", "\u00e3"); // ã small a, tilde
		s = s.replaceAll("&#228;", "\u00e4"); // ä small a, dieresis or umlaut
												// mark
		s = s.replaceAll("&#229;", "\u00e5"); // å small a, ring
		s = s.replaceAll("&#230;", "\u00e6"); // æ small ae diphthong (ligature)
		s = s.replaceAll("&#231;", "\u00e7"); // ç small c, cedilla
		s = s.replaceAll("&#232;", "\u00e8"); // è small e, grave accent
		s = s.replaceAll("&#233;", "\u00e9"); // é small e, acute accent
		s = s.replaceAll("\u00ea", "&#234;"); // ê small e, circumflex accent
		s = s.replaceAll("\u00eb", "&#235;"); // ë small e, dieresis or umlaut
												// mark
		s = s.replaceAll("\u00ec", "&#236;"); // ì small i, grave accent
		s = s.replaceAll("\u00ed", "&#237;"); // í small i, acute accent
		s = s.replaceAll("\u00ee", "&#238;"); // î small i, circumflex accent
		s = s.replaceAll("\u00ef", "&#239;"); // ï small i, dieresis or umlaut
												// mark
		s = s.replaceAll("\u00f0", "&#240;"); // ð small eth, Icelandic
		s = s.replaceAll("\u00f1", "&#241;"); // ñ small n, tilde
		s = s.replaceAll("\u00f2", "&#242;"); // ò small o, grave accent
		s = s.replaceAll("\u00f3", "&#243;"); // ó small o, acute accent
		s = s.replaceAll("\u00f4", "&#244;"); // ô small o, circumflex accent
		s = s.replaceAll("\u00f5", "&#245;"); // õ small o, tilde
		s = s.replaceAll("\u00f6", "&#246;"); // ö small o, dieresis or umlaut
												// mark
		s = s.replaceAll("\u00f7", "&#247;"); // ÷ divide sign
		s = s.replaceAll("\u00f8", "&#248;"); // ø small o, slash
		s = s.replaceAll("\u00f9", "&#249;"); // ù small u, grave accent
		s = s.replaceAll("\u00fa", "&#250;"); // ú small u, acute accent
		s = s.replaceAll("\u00fb", "&#251;"); // û small u, circumflex accent
		s = s.replaceAll("\u00fc", "&#252;"); // ü small u, dieresis or umlaut
												// mark
		s = s.replaceAll("\u00fd", "&#253;"); // ý small y, acute accent
		s = s.replaceAll("\u00fe", "&#254;"); // þ small thorn,
		s = s.replaceAll("\u00ff", "&#255;"); // " ÿ Icelandic ÿendif.

		return s;
	}

}
