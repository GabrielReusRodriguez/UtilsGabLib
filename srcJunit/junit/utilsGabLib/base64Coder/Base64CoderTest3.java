package junit.utilsGabLib.base64Coder;

import static org.junit.Assert.*;

import java.nio.charset.Charset;

import org.junit.Test;

import utilsGabLib.base64.Base64Coder;
import utilsGabLib.exceptions.UtilsGabLibException;
import utilsGabLib.string.encode.CharEncode;

public class Base64CoderTest3 {

	//Codificamos -decodificamos un string en utf-8
	@Test
	public void test() {
		//fail("Not yet implemented");
		
		String payload = new String("gbairéleéèé`´ äë¨s¨s¨SçñÑâÊ".getBytes(),Charset.forName("UTF-8"));
		String b64Payload = null;
		String decoded = null;
		
		b64Payload = Base64Coder.encode(payload);
		try {
			decoded = Base64Coder.decode(b64Payload, CharEncode.UTF8);
		} catch (UtilsGabLibException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			fail("Error: excepcion lanzada mientras se decodifica");
		}
		
		if( !payload.equalsIgnoreCase(decoded) ) {
			fail("Error: el valor original y el codificado - decodificado no son iguales.");
		}
		
	}

}
