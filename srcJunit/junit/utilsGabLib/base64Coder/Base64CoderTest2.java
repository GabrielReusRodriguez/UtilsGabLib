package junit.utilsGabLib.base64Coder;

import org.junit.Test;

import utilsGabLib.base64.Base64Coder;
import utilsGabLib.exceptions.UtilsGabLibException;

public class Base64CoderTest2 {

		//Comprobamos que nos devuelve una excepción si el String es null.
	@Test(expected = UtilsGabLibException.class)
	//@Test(expected = NullPointerException.class)
	public void test() {
		//fail("Not yet implemented");
		
		String payload = null;
		Base64Coder.encode(payload);
		
	}

}
