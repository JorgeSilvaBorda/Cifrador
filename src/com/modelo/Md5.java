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
	md.update(mensaje.getBytes());
	byte[] digest = md.digest();
	StringBuilder str = new StringBuilder();
	for (byte b : digest) {
	    str.append(Integer.toHexString(0xFF & b));
	}
	return str.toString();
    }
    
    public String cifrarBase64(String mensaje) throws NoSuchAlgorithmException {
	MessageDigest md = MessageDigest.getInstance("MD5");
	md.update(mensaje.getBytes());
	byte[] digest = md.digest();
	byte[] encoded = Base64.getEncoder().encode(digest);
	return new String(encoded);
    }
}
