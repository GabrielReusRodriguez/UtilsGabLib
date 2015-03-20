package utilsGabLib.xml.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import utilsGabLib.encode.CharEncode;
import utilsGabLib.xml.interfaces.XMLMetadataGetterInterface;

public class XMLMetadataGetter implements XMLMetadataGetterInterface{

	public XMLMetadataGetter() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public CharEncode guessEncodeByXMLTag(String xml) {
		
		String tagXML = getXMLTag(xml);
		tagXML = tagXML.toUpperCase();
		if(isEncodedIn(tagXML, CharEncode.UTF8)){
			return CharEncode.UTF8;
		}
		if(isEncodedIn(tagXML, CharEncode.ISO_8859_1)){
			return CharEncode.ISO_8859_1;
		}
		return CharEncode.UNKNOWN;
	}
	
	
	private String getXMLTag(String xml){
		
		String tagXML="";
		String copyXML = new String(xml);
		copyXML.replaceFirst("?>", "?>\n");
		copyXML.replaceFirst("?&gt;", "?&gt;\n");
		tagXML =  copyXML.substring(xml.indexOf('\n')+1);
		return tagXML;
		
	}
	
	private boolean isEncodedIn(String tagXML,CharEncode encode){
		String regexp = encode.toString();
		Pattern pattern = Pattern.compile(regexp);
		Matcher matcher = pattern.matcher(tagXML);
		return matcher.matches();
	}

}
