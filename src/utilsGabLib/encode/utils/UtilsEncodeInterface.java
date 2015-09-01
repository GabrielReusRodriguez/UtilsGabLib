package utilsGabLib.encode.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;

import utilsGabLib.exceptions.UtilsGabLibException;

public interface UtilsEncodeInterface {
	
	public byte[] encode(String original) throws UtilsGabLibException;
	public String charsToXMLEntities(String s);
	public String xmlEntitiesToChars(String s);

	public final static String basicCharsRegExp ="a-zA-Z0-9áàäéèëíìïóóòöúùüÁÀÄÉÈËÍÌÏÓÒÖÚÙÜçñÇÑ\\\\<>\\+\\-\\?¿=\\\"\\'\\.,:;_@!€$\\&\\(\\)/";
	public final static String replaceChar ="_";
	
	public static String convertStreamToString(InputStream is) throws IOException {
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
					Reader reader = new BufferedReader(new InputStreamReader(is));
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

	public static String removeComplexChars(String input){
		String cleanText="";
		
		return cleanText;
	}
}
