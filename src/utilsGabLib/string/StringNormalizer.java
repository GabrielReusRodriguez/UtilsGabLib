/**
 * 
 */
package utilsGabLib.string;

/**
 * @author gabriel
 *
 */
public class StringNormalizer {

	public final static String basicCharsRegExp ="[^a-zA-Z0-9áàäéèëíìïóóòöúùüÁÀÄÉÈËÍÌÏÓÒÖÚÙÜçñÇÑ\\\\<>\\+\\-\\?¿=\\\"\\'\\.,:;_@!€$\\&\\(\\)/\\*#!\\%]";
	
	public final static String replaceChar ="_";
	
	public String normalizeText(String text){
		return text.replaceAll(basicCharsRegExp, replaceChar);
	}
		
}
