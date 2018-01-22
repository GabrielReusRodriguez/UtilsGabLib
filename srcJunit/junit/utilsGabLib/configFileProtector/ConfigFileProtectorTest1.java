package junit.utilsGabLib.configFileProtector;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

import org.junit.Test;

import utilsGabLib.config.ConfigFileProtector;

public class ConfigFileProtectorTest1 {

	
	//Comprobamos si la codificación - decodificacion funciona bien.
	@Test
	public void test() {
		
		
		//fail("Not yet implemented");
		String password ="Gabriel";
		String encryptedPassword ="";
		String decryptedPassword ="";
		
		
		ConfigFileProtector cfgProtector = new ConfigFileProtector();
		try {
			encryptedPassword = cfgProtector.encrypt("Gabriel");
		} catch (UnsupportedEncodingException | GeneralSecurityException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			fail("Exception thrown encrypting string");
		}
		
		
		try {
			decryptedPassword = cfgProtector.decrypt(encryptedPassword);
		} catch (GeneralSecurityException | IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			fail("Exception thrown decrypting string");
		}
		
		if (!password.equalsIgnoreCase(decryptedPassword)) {
			fail("Encrypted - decrypted password is not the same as original");
		}
		
		
		
	}

}
