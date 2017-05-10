package com.modelo;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;


/**
 * Convierte frases a Hash MD5.
 *
 * @author Jorge Silva Borda
 */
public class Md5 {

    /**
     * Constructor vacío.
     */
    public Md5() {

    }

    /**
     * Cifra un mensaje en algoritmo MD5
     * @param mensaje {@link java.lang.String} con el mensaje a cifrar.
     * @return {@link java.lang.String} con el mensaje cifrado en MD5.
     * @throws NoSuchAlgorithmException 
     */
    public String cifrar(String mensaje) throws NoSuchAlgorithmException {
	MessageDigest md = MessageDigest.getInstance("MD5");
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
