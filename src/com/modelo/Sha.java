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
	md.update("texto a cifrar".getBytes());
	byte[] digest = md.digest();

	// Se escribe byte a byte en hexadecimal
	for (byte b : digest) {
	    System.out.print(Integer.toHexString(0xFF & b));
	}
	System.out.println();

	// Se escribe codificado base 64. Se necesita la librería
	// commons-codec-x.x.x.jar de Apache
	byte[] encoded = Base64.getEncoder().encode(digest);
	return new String(encoded);
    }
}
