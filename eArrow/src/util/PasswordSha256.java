package util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* 
 * Classe per la criptazione della password
 */

public class PasswordSha256 {
	/**
	 * Cripta in SHA256 la stringa passata come parametro
	 */
	public static String getEncodedpassword(String clearTextPassword) throws NoSuchAlgorithmException  {
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(clearTextPassword.getBytes());
		
		return HexString.bufferToHex(md.digest()); //effettua il padding finale
		
	}

	/**
	 * Testa se la password in chiaro e la password criptata sono uguali
	 */
	public static boolean testPassword(String clearTextTestPassword, String encodedActualPassword) throws NoSuchAlgorithmException{
		String encodedTestPassword = getEncodedpassword(clearTextTestPassword);
		 return (encodedTestPassword.equals(encodedActualPassword));
		
	}
	
}
