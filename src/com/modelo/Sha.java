package com.modelo;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * Cifra los datos en algoritmos SHA
 *
 * @author Jorge Silva Borda
 */
public class Sha {

    /**
     * Constructor vacío.
     */
    public Sha() {

    }

    public String cifrarSha1(String mensaje) throws NoSuchAlgorithmException {
	MessageDigest md = MessageDigest.getInstance("SHA-1");
	md.update(mensaje.getBytes());
	byte[] digest = md.digest();
	StringBuilder str = new StringBuilder();
	for (byte b : digest) {
	    System.out.print(Integer.toHexString(0xFF & b));
	    str.append(Integer.toHexString(0xFF & b));
	}
	return str.toString();
    }
    
    public String cifrarSha1_Base64(String mensaje) throws NoSuchAlgorithmException {
	MessageDigest md = MessageDigest.getInstance("SHA-1");
	md.update(mensaje.getBytes());
	byte[] digest = md.digest();
	byte[] encoded = Base64.getEncoder().encode(digest);
	return new String(encoded);
    }
    
    public String cifrarSha256_Base64(String mensaje) throws NoSuchAlgorithmException {
	MessageDigest md = MessageDigest.getInstance("SHA-256");
	md.update(mensaje.getBytes());
	byte[] digest = md.digest();
	byte[] encoded = Base64.getEncoder().encode(digest);
	return new String(encoded);
    }
    
    public String cifrarSha256(String mensaje) throws NoSuchAlgorithmException {
	MessageDigest md = MessageDigest.getInstance("SHA-256");
	md.update(mensaje.getBytes());
	byte[] digest = md.digest();

	// Se escribe byte a byte en hexadecimal
	StringBuilder sr = new StringBuilder();
	for (byte b : digest) {
	    System.out.print(Integer.toHexString(0xFF & b));
	    sr.append(Integer.toHexString(0xFF & b));
	}
	return sr.toString();
    }
}
