package utilsGabLib.xml.impl;

import utilsGabLib.string.encode.CharEncode;
import utilsGabLib.xml.interfaces.XMLMetadataGetterInterface;

public class XMLMetadataGetter implements XMLMetadataGetterInterface{

	public XMLMetadataGetter() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public CharEncode guessEncodeByXMLTag(String xml) {
		
		String tagXML = getXMLTag(xml);
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
		tagXML = xml.substring(xml.indexOf("?>")+2);
		return tagXML;
		
	}
	
	private boolean isEncodedIn(String tagXML,CharEncode encode){
		return tagXML.toUpperCase().contains(encode.toString());
	}

}
