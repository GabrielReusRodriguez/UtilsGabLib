package utilsGabLib.streams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;

public class StreamManager {

	public String stream2String(InputStream is) throws IOException {
		 /*
		 * To convert the InputStream to String we use the
		 * Reader.read(char[] buffer) method. We iterate until the
		 * Reader return -1 which means there's no more data to
		 * read. We use the StringWriter class to produce the string.
		 */
			if (is != null) 
			{
				Writer writer = new StringWriter();
		
				char[] buffer = new char[1024];
				
				try
				{
					Reader reader = new BufferedReader(new InputStreamReader(is, "ISO-8859-1"));
					int n;
					while ((n = reader.read(buffer)) != -1) 
					{
						writer.write(buffer, 0, n);
					}
					
				}
				finally
				{
					is.close();
				}
				return writer.toString();
			}
			else
			{
				return "";
			}
		}
	
	public InputStream string2Stream(String input) throws IOException {
		//TODO:
		return null;
	}
	
	
	
	public static String undoReplaceNoUTF8(String s)
	{
		s = s.replaceAll("&#161;","¡"); //inverted exclamation mark
	    s = s.replaceAll("&#162;","¢"); //cent sign
	    s = s.replaceAll("&#163;","£"); //pound sterling sign
	    s = s.replaceAll("&#164;","¤"); //general currency sign
	    s = s.replaceAll("&#165;","¥"); //yen sign
	    s = s.replaceAll("&#166;","¦"); //broken (vertical) bar
	    s = s.replaceAll("&#167;","§"); //section sign
	    s = s.replaceAll("&#168;","¨"); //umlaut (dieresis)
	    s = s.replaceAll("&#169;","©"); //copyright sign
	    s = s.replaceAll("&#170;","ª"); //ordinal indicator, feminine
	    s = s.replaceAll("&#171;","«"); //angle quotation mark, left
	    s = s.replaceAll("&#172;","¬"); //not sign ­
	                                                    //soft hyphen
	    s = s.replaceAll("&#174;","®"); //registered sign
	    s = s.replaceAll("&#175;","¯"); //macron
	    s = s.replaceAll("&#176;","°"); //degree sign
	    s = s.replaceAll("&#177;","±"); //plus-or-minus sign
	    s = s.replaceAll("&#178;","²"); //superscript two
	    s = s.replaceAll("&#179;","³"); //superscript three
	    s = s.replaceAll("&#180;","´"); //acute accent
	    s = s.replaceAll("&#181;","µ"); //micro sign
	    s = s.replaceAll("&#182;","¶"); //pilcrow (paragraph sign)
	    s = s.replaceAll("&#183;","·"); //middle dot
	    s = s.replaceAll("&#184;","¸"); //cedilla
	    s = s.replaceAll("&#185;","¹"); //superscript one
	    s = s.replaceAll("&#186;","º"); //ordinal indicator, masculine
	    s = s.replaceAll("&#187;","»"); //angle quotation mark, right
	    s = s.replaceAll("&#188;","¼"); //fraction one-quarter
	    s = s.replaceAll("&#189;","½"); //fraction one-half
	    s = s.replaceAll("&#190;","¾"); //fraction three-quarters
	    s = s.replaceAll("&#191;","¿"); //inverted question mark
	    s = s.replaceAll("&#192;","À"); //capital A, grave accent
	    s = s.replaceAll("&#193;","Á"); //capital A, acute accent
	    s = s.replaceAll("&#194;","Â"); //capital A, circumflex accent
	    s = s.replaceAll("&#195;","Ã"); //capital A, tilde Ä => capital
	    s = s.replaceAll("&#196;","Ä"); //capital A, dieresis or umlaut mark
	    s = s.replaceAll("&#197;","Å"); //capital A, ring
	    s = s.replaceAll("&#198;","Æ"); //capital AE diphthong (ligature)
	    s = s.replaceAll("&#199;","Ç"); //capital C, cedilla
	    s = s.replaceAll("&#200;","È"); //capital E, grave accent
	    s = s.replaceAll("&#201;","É"); //capital E, acute accent
	    s = s.replaceAll("&#202;","Ê"); //capital E, circumflex accent
	    s = s.replaceAll("&#203;","Ë"); //capital E, dieresis or umlaut mark
	    s = s.replaceAll("&#204;","Ì"); //capital I, grave accent
	    s = s.replaceAll("&#205;","Í"); //capital I, acute accent
	    s = s.replaceAll("&#206;","Î"); //capital I, circumflex accent
	    s = s.replaceAll("&#207;","Ï"); //capital I, dieresis or umlaut mark
	    s = s.replaceAll("&#208;","Ð"); //capital Eth, Icelandic
	    s = s.replaceAll("&#209;","Ñ"); //capital N, tilde
	    s = s.replaceAll("&#210;","Ò"); //capital O, grave accent
	    s = s.replaceAll("&#211;","Ó"); //capital O, acute accent
	    s = s.replaceAll("&#212;","Ô"); //capital O, circumflex accent
	    s = s.replaceAll("&#213;","Õ"); //capital O, tilde
	    s = s.replaceAll("&#214;","Ö"); //capital O, dieresis or umlaut mark
	    s = s.replaceAll("&#215;","×"); //multiply sign
	    s = s.replaceAll("&#216;","Ø"); //capital O, slash
	    s = s.replaceAll("&#217;","Ù"); //capital U, grave accent
	    s = s.replaceAll("&#218;","Ú"); //capital U, acute accent
	    s = s.replaceAll("&#219;","Û"); //capital U, circumflex accent
	    s = s.replaceAll("&#220;","Ü"); //capital U, dieresis or umlaut mark
	    s = s.replaceAll("&#221;","Ý"); //capital Y, acute accent
	    s = s.replaceAll("&#222;","Þ"); //capital THORN, Icelandic
	    s = s.replaceAll("&#223;","ß"); //small sharp s, German (sz ligature)
	    s = s.replaceAll("&#224;","à"); //small a, grave accent
	    s = s.replaceAll("&#225;","á"); //small a, acute accent
	    s = s.replaceAll("&#226;","â"); //small a, circumflex accent
	    s = s.replaceAll("&#227;","ã"); //small a, tilde
	    s = s.replaceAll("&#228;","ä"); //small a, dieresis or umlaut mark
	    s = s.replaceAll("&#229;","å"); //small a, ring
	    s = s.replaceAll("&#230;","æ"); //small ae diphthong (ligature)
	    s = s.replaceAll("&#231;","ç"); //small c, cedilla
	    s = s.replaceAll("&#232;","è"); //small e, grave accent
	    s = s.replaceAll("&#233;","é"); //small e, acute accent
	    s = s.replaceAll("&#234;","ê"); //small e, circumflex accent
	    s = s.replaceAll("&#235;","ë"); //small e, dieresis or umlaut mark
	    s = s.replaceAll("&#236;","ì"); //small i, grave accent
	    s = s.replaceAll("&#237;","í"); //small i, acute accent
	    s = s.replaceAll("&#238;","î"); //small i, circumflex accent
	    s = s.replaceAll("&#239;","ï"); //small i, dieresis or umlaut mark
	    s = s.replaceAll("&#240;","ð"); //small eth, Icelandic
	    s = s.replaceAll("&#241;","ñ"); //small n, tilde
	    s = s.replaceAll("&#242;","ò"); //small o, grave accent
	    s = s.replaceAll("&#243;","ó"); //small o, acute accent
	    s = s.replaceAll("&#244;","ô"); //small o, circumflex accent
	    s = s.replaceAll("&#245;","õ"); //small o, tilde
	    s = s.replaceAll("&#246;","ö"); //small o, dieresis or umlaut mark
	    s = s.replaceAll("&#247;","÷"); //divide sign
	    s = s.replaceAll("&#248;","ø"); //small o, slash
	    s = s.replaceAll("&#249;","ù"); //small u, grave accent
	    s = s.replaceAll("&#250;","ú"); //small u, acute accent
	    s = s.replaceAll("&#251;","û"); //small u, circumflex accent
	    s = s.replaceAll("&#252;","ü"); //small u, dieresis or umlaut mark
	    s = s.replaceAll("&#253;","ý"); //small y, acute accent
	    s = s.replaceAll("&#254;","þ"); //small thorn, 
	    s = s.replaceAll("&#255;","ÿ"); //"Icelandic ÿendif.
	    
	    return s;
	}
	
}
