package utilsGabLib.config;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

import utilsGabLib.base64.Base64Coder;
import utilsGabLib.string.encode.CharEncode;

public class ConfigFileProtector {

	protected String algoritmo = "PBEWithMD5AndDES";
	protected String codificacionCaracteres = "UTF-8";
    protected  char[] PASSWORD = "enfldsgbnlsngdlksdsgm".toCharArray();
    protected  byte[] SALT = {
        (byte) 0xde, (byte) 0x33, (byte) 0x10, (byte) 0x12,
        (byte) 0xde, (byte) 0x33, (byte) 0x10, (byte) 0x12,
    };
	
	public ConfigFileProtector() {
	}

	
	public ConfigFileProtector(String algoritmo){
		this.algoritmo = algoritmo;
	}
	
	
	public ConfigFileProtector(String algoritmo, CharEncode encode){
		this.algoritmo = algoritmo;
		this.codificacionCaracteres = encode.toString();
	}
	
	public ConfigFileProtector(String algoritmo, CharEncode encode, char[] password, byte[] salt){
		this.algoritmo = algoritmo;
		this.codificacionCaracteres = encode.toString();
		this.PASSWORD = password;
		this.SALT = salt;
	}
	
	public ConfigFileProtector(char[] password, byte[] salt){
		this.PASSWORD = password;
		this.SALT = salt;
	}
	
	public ConfigFileProtector(char[] password){
		this.PASSWORD = password;
	}
	
	
	public String encrypt(String property)
			throws GeneralSecurityException, UnsupportedEncodingException {
		SecretKeyFactory keyFactory = SecretKeyFactory
				.getInstance(algoritmo);
		SecretKey key = keyFactory.generateSecret(new PBEKeySpec(PASSWORD));
		Cipher pbeCipher = Cipher.getInstance(algoritmo);
		pbeCipher
				.init(Cipher.ENCRYPT_MODE, key, new PBEParameterSpec(SALT, 20));
		return base64Encode(pbeCipher.doFinal(property.getBytes(codificacionCaracteres)));
	}

	protected String base64Encode(byte[] bytes) {
		// NB: This class is internal, and you probably should use another impl
		//return new BASE64Encoder().encode(bytes);
		return Base64Coder.encode(bytes);
	}

	public String decrypt(String property)
			throws GeneralSecurityException, IOException {
		SecretKeyFactory keyFactory = SecretKeyFactory
				.getInstance(algoritmo);
		SecretKey key = keyFactory.generateSecret(new PBEKeySpec(PASSWORD));
		Cipher pbeCipher = Cipher.getInstance(algoritmo);
		pbeCipher
				.init(Cipher.DECRYPT_MODE, key, new PBEParameterSpec(SALT, 20));
		return new String(pbeCipher.doFinal(base64Decode(property)), codificacionCaracteres);
	}

	protected static byte[] base64Decode(String property) throws IOException {
		// NB: This class is internal, and you probably should use another impl
		//return new BASE64Decoder().decodeBuffer(property);
		return Base64Coder.decode(property).getBytes();
	}

	
	
	public static void main(String[] args) throws Exception {
		String password ="Gabriel";
		ConfigFileProtector cfgProtector = new ConfigFileProtector(password.toCharArray());
        String originalPassword = "secret";
        System.out.println("Original password: " + originalPassword);
        String encryptedPassword = cfgProtector.encrypt(originalPassword);
        System.out.println("Encrypted password: " + encryptedPassword);
        String decryptedPassword = cfgProtector.decrypt(encryptedPassword);
        System.out.println("Decrypted password: " + decryptedPassword);
    }

	
}
