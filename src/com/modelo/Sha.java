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
}
