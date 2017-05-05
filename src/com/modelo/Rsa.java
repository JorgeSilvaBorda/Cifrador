package com.modelo;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/**
 * Cifra frases por medio de llave compartida.
 *
 * @author Jorge Silva Borda
 */
public class Rsa {

    private KeyPairGenerator keyGen;
    private KeyPair clavesRSA;
    private final PrivateKey clavePrivada;
    private final PublicKey clavePublica;

    /**
     * Constructor.
     * @param bitLen {@link java.lang.Integer} con la profundidad de bits del
     * cifrado.
     * @throws java.security.NoSuchAlgorithmException
     */
    public Rsa(int bitLen) throws NoSuchAlgorithmException {
	this.keyGen = KeyPairGenerator.getInstance("RSA");
	this.keyGen.initialize(bitLen);
	this.clavesRSA = keyGen.generateKeyPair();
	this.clavePrivada = clavesRSA.getPrivate();
	this.clavePublica = clavesRSA.getPublic();
	System.out.println("Clave privada: " + clavePrivada);
	System.out.println("Clave pública: " + clavePublica);
    }

    public String cifrar(String mensaje) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
	byte[] buffer = mensaje.getBytes();

	Cipher cifrador = Cipher.getInstance("RSA");
	cifrador.init(Cipher.ENCRYPT_MODE, this.clavePublica);
	byte[] cifrado = cifrador.doFinal(buffer);
	String str = new String(cifrado, "UTF-8");
	return str;
    }
    
    public String descifrar(String mensaje) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException{
	byte[] cifrado = mensaje.getBytes();
	Cipher cifrador = Cipher.getInstance("RSA");
	cifrador.init(Cipher.DECRYPT_MODE, this.clavePrivada);
	byte[] descifrado = cifrador.doFinal(cifrado);
	return new String(descifrado, "UTF-8");
    }
}
