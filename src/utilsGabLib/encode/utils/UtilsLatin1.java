package utilsGabLib.encode.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;

import utilsGabLib.encode.CharEncode;
import utilsGabLib.exceptions.UtilsGabLibException;

public class UtilsLatin1 implements UtilsEncodeInterface{


	
	public static String undoReplaceNoUTF8(String s)
	{
		/*
		s = s.replaceAll("&amp;","&");
//		s = s.replaceAll("&lt;","<");
//		s = s.replaceAll("&gt;",">");
//		s = s.replaceAll("&quot;","\"");
//		s = s.replaceAll("&apos;","'");
//		s = s.replaceAll("&lt;","<");
//		s = s.replaceAll("&gt;",">");
 */
		s = s.replaceAll("&#161;","�"); //inverted exclamation mark
	    s = s.replaceAll("&#162;","�"); //cent sign
	    s = s.replaceAll("&#163;","�"); //pound sterling sign
	    s = s.replaceAll("&#164;","�"); //general currency sign
	    s = s.replaceAll("&#165;","�"); //yen sign
	    s = s.replaceAll("&#166;","�"); //broken (vertical) bar
	    s = s.replaceAll("&#167;","�"); //section sign
	    s = s.replaceAll("&#168;","�"); //umlaut (dieresis)
	    s = s.replaceAll("&#169;","�"); //copyright sign
	    s = s.replaceAll("&#170;","�"); //ordinal indicator, feminine
	    s = s.replaceAll("&#171;","�"); //angle quotation mark, left
	    s = s.replaceAll("&#172;","�"); //not sign �
	                                                    //soft hyphen
	    s = s.replaceAll("&#174;","�"); //registered sign
	    s = s.replaceAll("&#175;","�"); //macron
	    s = s.replaceAll("&#176;","�"); //degree sign
	    s = s.replaceAll("&#177;","�"); //plus-or-minus sign
	    s = s.replaceAll("&#178;","�"); //superscript two
	    s = s.replaceAll("&#179;","�"); //superscript three
	    s = s.replaceAll("&#180;","�"); //acute accent
	    s = s.replaceAll("&#181;","�"); //micro sign
	    s = s.replaceAll("&#182;","�"); //pilcrow (paragraph sign)
	    s = s.replaceAll("&#183;","�"); //middle dot
	    s = s.replaceAll("&#184;","�"); //cedilla
	    s = s.replaceAll("&#185;","�"); //superscript one
	    s = s.replaceAll("&#186;","�"); //ordinal indicator, masculine
	    s = s.replaceAll("&#187;","�"); //angle quotation mark, right
	    s = s.replaceAll("&#188;","�"); //fraction one-quarter
	    s = s.replaceAll("&#189;","�"); //fraction one-half
	    s = s.replaceAll("&#190;","�"); //fraction three-quarters
	    s = s.replaceAll("&#191;","�"); //inverted question mark
	    s = s.replaceAll("&#192;","�"); //capital A, grave accent
	    s = s.replaceAll("&#193;","�"); //capital A, acute accent
	    s = s.replaceAll("&#194;","�"); //capital A, circumflex accent
	    s = s.replaceAll("&#195;","�"); //capital A, tilde � => capital
	    s = s.replaceAll("&#196;","�"); //capital A, dieresis or umlaut mark
	    s = s.replaceAll("&#197;","�"); //capital A, ring
	    s = s.replaceAll("&#198;","�"); //capital AE diphthong (ligature)
	    s = s.replaceAll("&#199;","�"); //capital C, cedilla
	    s = s.replaceAll("&#200;","�"); //capital E, grave accent
	    s = s.replaceAll("&#201;","�"); //capital E, acute accent
	    s = s.replaceAll("&#202;","�"); //capital E, circumflex accent
	    s = s.replaceAll("&#203;","�"); //capital E, dieresis or umlaut mark
	    s = s.replaceAll("&#204;","�"); //capital I, grave accent
	    s = s.replaceAll("&#205;","�"); //capital I, acute accent
	    s = s.replaceAll("&#206;","�"); //capital I, circumflex accent
	    s = s.replaceAll("&#207;","�"); //capital I, dieresis or umlaut mark
	    s = s.replaceAll("&#208;","�"); //capital Eth, Icelandic
	    s = s.replaceAll("&#209;","�"); //capital N, tilde
	    s = s.replaceAll("&#210;","�"); //capital O, grave accent
	    s = s.replaceAll("&#211;","�"); //capital O, acute accent
	    s = s.replaceAll("&#212;","�"); //capital O, circumflex accent
	    s = s.replaceAll("&#213;","�"); //capital O, tilde
	    s = s.replaceAll("&#214;","�"); //capital O, dieresis or umlaut mark
	    s = s.replaceAll("&#215;","�"); //multiply sign
	    s = s.replaceAll("&#216;","�"); //capital O, slash
	    s = s.replaceAll("&#217;","�"); //capital U, grave accent
	    s = s.replaceAll("&#218;","�"); //capital U, acute accent
	    s = s.replaceAll("&#219;","�"); //capital U, circumflex accent
	    s = s.replaceAll("&#220;","�"); //capital U, dieresis or umlaut mark
	    s = s.replaceAll("&#221;","�"); //capital Y, acute accent
	    s = s.replaceAll("&#222;","�"); //capital THORN, Icelandic
	    s = s.replaceAll("&#223;","�"); //small sharp s, German (sz ligature)
	    s = s.replaceAll("&#224;","�"); //small a, grave accent
	    s = s.replaceAll("&#225;","�"); //small a, acute accent
	    s = s.replaceAll("&#226;","�"); //small a, circumflex accent
	    s = s.replaceAll("&#227;","�"); //small a, tilde
	    s = s.replaceAll("&#228;","�"); //small a, dieresis or umlaut mark
	    s = s.replaceAll("&#229;","�"); //small a, ring
	    s = s.replaceAll("&#230;","�"); //small ae diphthong (ligature)
	    s = s.replaceAll("&#231;","�"); //small c, cedilla
	    s = s.replaceAll("&#232;","�"); //small e, grave accent
	    s = s.replaceAll("&#233;","�"); //small e, acute accent
	    s = s.replaceAll("&#234;","�"); //small e, circumflex accent
	    s = s.replaceAll("&#235;","�"); //small e, dieresis or umlaut mark
	    s = s.replaceAll("&#236;","�"); //small i, grave accent
	    s = s.replaceAll("&#237;","�"); //small i, acute accent
	    s = s.replaceAll("&#238;","�"); //small i, circumflex accent
	    s = s.replaceAll("&#239;","�"); //small i, dieresis or umlaut mark
	    s = s.replaceAll("&#240;","�"); //small eth, Icelandic
	    s = s.replaceAll("&#241;","�"); //small n, tilde
	    s = s.replaceAll("&#242;","�"); //small o, grave accent
	    s = s.replaceAll("&#243;","�"); //small o, acute accent
	    s = s.replaceAll("&#244;","�"); //small o, circumflex accent
	    s = s.replaceAll("&#245;","�"); //small o, tilde
	    s = s.replaceAll("&#246;","�"); //small o, dieresis or umlaut mark
	    s = s.replaceAll("&#247;","�"); //divide sign
	    s = s.replaceAll("&#248;","�"); //small o, slash
	    s = s.replaceAll("&#249;","�"); //small u, grave accent
	    s = s.replaceAll("&#250;","�"); //small u, acute accent
	    s = s.replaceAll("&#251;","�"); //small u, circumflex accent
	    s = s.replaceAll("&#252;","�"); //small u, dieresis or umlaut mark
	    s = s.replaceAll("&#253;","�"); //small y, acute accent
	    s = s.replaceAll("&#254;","�"); //small thorn, 
	    s = s.replaceAll("&#255;","�"); //"Icelandic �endif.
	    
	    return s;
	}
	
	public static String replaceNoUTF8(String s)
	{
		/*
		s = s.replaceAll("&","&amp;");
		s = s.replaceAll("<", "&lt;");
		s = s.replaceAll(">", "&gt;");
		s = s.replaceAll("ns1:", "");
		s = s.replaceAll("\"","&quot;");
		s = s.replaceAll("'","&apos;");
		s = s.replaceAll(":ns1", "");
		
		s = s.replaceAll("&","&amp;");
		s = s.replaceAll("<", "&lt;");
		s = s.replaceAll(">", "&gt;");
		s = s.replaceAll("ns0:", "");
		s = s.replaceAll("\"","&quot;");
		s = s.replaceAll("'","&apos;");
		s = s.replaceAll(":ns0", "");
		*/
		s = s.replaceAll("�","&#161;"); //inverted exclamation mark
	    s = s.replaceAll("�","&#162;"); //cent sign
	    s = s.replaceAll("�","&#163;"); //pound sterling sign
	    s = s.replaceAll("�","&#164;"); //general currency sign
	    s = s.replaceAll("�","&#165;"); //yen sign
	    s = s.replaceAll("�","&#166;"); //broken (vertical) bar
	    s = s.replaceAll("�","&#167;"); //section sign
	    s = s.replaceAll("�","&#168;"); //umlaut (dieresis)
	    s = s.replaceAll("�","&#169;"); //copyright sign
	    s = s.replaceAll("�","&#170;"); //ordinal indicator, feminine
	    s = s.replaceAll("�","&#171;"); //angle quotation mark, left
	    s = s.replaceAll("�","&#172;"); //not sign �
	                                                    //soft hyphen
	    s = s.replaceAll("�","&#174;"); //registered sign
	    s = s.replaceAll("�","&#175;"); //macron
	    s = s.replaceAll("�","&#176;"); //degree sign
	    s = s.replaceAll("�","&#177;"); //plus-or-minus sign
	    s = s.replaceAll("�","&#178;"); //superscript two
	    s = s.replaceAll("�","&#179;"); //superscript three
	    s = s.replaceAll("�","&#180;"); //acute accent
	    s = s.replaceAll("�","&#181;"); //micro sign
	    s = s.replaceAll("�","&#182;"); //pilcrow (paragraph sign)
	    s = s.replaceAll("�","&#183;"); //middle dot
	    //s = s.replaceAll("�","&#183;"); //middle dot
	    s = s.replaceAll("�","&#184;"); //cedilla
	    s = s.replaceAll("�","&#185;"); //superscript one
	    s = s.replaceAll("�","&#186;"); //ordinal indicator, masculine
	    s = s.replaceAll("�","&#187;"); //angle quotation mark, right
	    s = s.replaceAll("�","&#188;"); //fraction one-quarter
	    s = s.replaceAll("�","&#189;"); //fraction one-half
	    s = s.replaceAll("�","&#190;"); //fraction three-quarters
	    s = s.replaceAll("�","&#191;"); //inverted question mark
	    s = s.replaceAll("�","&#192;"); //capital A, grave accent
	    s = s.replaceAll("�","&#193;"); //capital A, acute accent
	    s = s.replaceAll("�","&#194;"); //capital A, circumflex accent
	    s = s.replaceAll("�","&#195;"); //capital A, tilde � => capital
	    s = s.replaceAll("�","&#196;"); //capital A, dieresis or umlaut mark
	    s = s.replaceAll("�","&#197;"); //capital A, ring
	    s = s.replaceAll("�","&#198;"); //capital AE diphthong (ligature)
	    s = s.replaceAll("�","&#199;"); //capital C, cedilla
	    s = s.replaceAll("�","&#200;"); //capital E, grave accent
	    s = s.replaceAll("�","&#201;"); //capital E, acute accent
	    s = s.replaceAll("�","&#202;"); //capital E, circumflex accent
	    s = s.replaceAll("�","&#203;"); //capital E, dieresis or umlaut mark
	    s = s.replaceAll("�","&#204;"); //capital I, grave accent
	    s = s.replaceAll("�","&#205;"); //capital I, acute accent
	    s = s.replaceAll("�","&#206;"); //capital I, circumflex accent
	    s = s.replaceAll("�","&#207;"); //capital I, dieresis or umlaut mark
	    s = s.replaceAll("�","&#208;"); //capital Eth, Icelandic
	    s = s.replaceAll("�","&#209;"); //capital N, tilde
	    s = s.replaceAll("�","&#210;"); //capital O, grave accent
	    s = s.replaceAll("�","&#211;"); //capital O, acute accent
	    s = s.replaceAll("�","&#212;"); //capital O, circumflex accent
	    s = s.replaceAll("�","&#213;"); //capital O, tilde
	    s = s.replaceAll("�","&#214;"); //capital O, dieresis or umlaut mark
	    s = s.replaceAll("�","&#215;"); //multiply sign
	    s = s.replaceAll("�","&#216;"); //capital O, slash
	    s = s.replaceAll("�","&#217;"); //capital U, grave accent
	    s = s.replaceAll("�","&#218;"); //capital U, acute accent
	    s = s.replaceAll("�","&#219;"); //capital U, circumflex accent
	    s = s.replaceAll("�","&#220;"); //capital U, dieresis or umlaut mark
	    s = s.replaceAll("�","&#221;"); //capital Y, acute accent
	    s = s.replaceAll("�","&#222;"); //capital THORN, Icelandic
	    s = s.replaceAll("�","&#223;"); //small sharp s, German (sz ligature)
	    s = s.replaceAll("�","&#224;"); //small a, grave accent
	    s = s.replaceAll("�","&#225;"); //small a, acute accent
	    s = s.replaceAll("�","&#226;"); //small a, circumflex accent
	    s = s.replaceAll("�","&#227;"); //small a, tilde
	    s = s.replaceAll("�","&#228;"); //small a, dieresis or umlaut mark
	    s = s.replaceAll("�","&#229;"); //small a, ring
	    s = s.replaceAll("�","&#230;"); //small ae diphthong (ligature)
	    s = s.replaceAll("�","&#231;"); //small c, cedilla
	    s = s.replaceAll("�","&#232;"); //small e, grave accent
	    s = s.replaceAll("�","&#233;"); //small e, acute accent
	    s = s.replaceAll("�","&#234;"); //small e, circumflex accent
	    s = s.replaceAll("�","&#235;"); //small e, dieresis or umlaut mark
	    s = s.replaceAll("�","&#236;"); //small i, grave accent
	    s = s.replaceAll("�","&#237;"); //small i, acute accent
	    s = s.replaceAll("�","&#238;"); //small i, circumflex accent
	    s = s.replaceAll("�","&#239;"); //small i, dieresis or umlaut mark
	    s = s.replaceAll("�","&#240;"); //small eth, Icelandic
	    s = s.replaceAll("�","&#241;"); //small n, tilde
	    s = s.replaceAll("�","&#242;"); //small o, grave accent
	    s = s.replaceAll("�","&#243;"); //small o, acute accent
	    s = s.replaceAll("�","&#244;"); //small o, circumflex accent
	    s = s.replaceAll("�","&#245;"); //small o, tilde
	    s = s.replaceAll("�","&#246;"); //small o, dieresis or umlaut mark
	    s = s.replaceAll("�","&#247;"); //divide sign
	    s = s.replaceAll("�","&#248;"); //small o, slash
	    s = s.replaceAll("�","&#249;"); //small u, grave accent
	    s = s.replaceAll("�","&#250;"); //small u, acute accent
	    s = s.replaceAll("�","&#251;"); //small u, circumflex accent
	    s = s.replaceAll("�","&#252;"); //small u, dieresis or umlaut mark
	    s = s.replaceAll("�","&#253;"); //small y, acute accent
	    s = s.replaceAll("�","&#254;"); //small thorn, 
	    s = s.replaceAll("�","&#255;"); //"Icelandic �endif.
	    
	    return s;
	}

	@Override
	public byte[] encode(String original) throws UtilsGabLibException {
		return original.getBytes(CharEncode.ISO_8859_1.toCharset());
	}

	@Override
	public String charsToXMLEntities(String s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String xmlEntitiesToChars(String s) {
		// TODO Auto-generated method stub
		return null;
	}
	

	
	
}
