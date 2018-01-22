package junit.utilsGabLib.base64Coder;

import static org.junit.Assert.*;

import org.apache.commons.codec.binary.Base64;
import org.junit.Test;

import utilsGabLib.base64.Base64Coder;

public class Base64CoderTest1 {

	//Testeamos la codificación -decodificacion basica.
	@Test
	public void test() {
		//fail("Not yet implemented");
		String payload = "Valor codificado 1";
		String b64String =null;
		String decodedPayload = null;
		
		b64String = Base64Coder.encode(payload);
		decodedPayload = new String(Base64.decodeBase64(b64String));
		
		if(!payload.equalsIgnoreCase(decodedPayload)) {
			fail("El payload y el valor codificado - decodificado no son el mismo.");
		}
		
	}

}
