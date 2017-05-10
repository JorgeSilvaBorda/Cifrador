package com.modelo;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * Cifrado de mensajes mediante algoritmo AES.
 * @author Jorge Silva Borda
 */
public class Aes {
    
    /**
     * Constructor vacío.
     */
    public Aes(){
	
    }
    
    /**
     * Cifra un texto usando el algoritmo aes con clave de 16 caracteres.
     * La clave para cifrar el mensaje debe contener exactamente 16 caracteres.
     * De lo contrario dispara una {@link AESKeyException}.
     * @param texto {@link java.lang.String} con el texto a cifrar.
     * @param clave {@link java.lang.String} con la clave compartida.
     * @return {@link java.lang.String} con el texto cifrado.
     * @throws NoSuchAlgorithmException
     * @throws NoSuchPaddingException
     * @throws InvalidKeyException
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException
     * @throws AESKeyException 
     */
    public String cifrar(String texto, String clave) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, AESKeyException{
	if(clave.length() < 16 || clave.length() > 16){
	    throw new AESKeyException(clave.length());
	}
	SecretKeySpec key = new SecretKeySpec(clave.getBytes(), "AES");
	Cipher cipher = Cipher.getInstance("AES");
	cipher.init(Cipher.ENCRYPT_MODE, key);
	byte[] cifrado = cipher.doFinal(texto.getBytes());
	return new BASE64Encoder().encode(cifrado);
    }
    
    /**
     * Descifra un texto usando el algoritmo aes con clave de 16 caracteres.
     * La clave para descifrar el mensaje debe contener exactamente 16 caracteres.
     * De lo contrario dispara una {@link AESKeyException}.
     * @param textoCifrado {@link java.lang.String} con el texto cifrado.
     * @param clave {@link java.lang.String} con la clave compartida.
     * @return {@link java.lang.String} con el texto descifrado.
     * @throws NoSuchAlgorithmException
     * @throws NoSuchPaddingException
     * @throws InvalidKeyException
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException
     * @throws AESKeyException 
     */
    public String desCifrar(String textoCifrado, String clave) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException, IOException, AESKeyException{
	if(clave.length() < 16 || clave.length() > 16){
	    throw new AESKeyException(clave.length());
	}
	byte[] cifrado = new BASE64Decoder().decodeBuffer(textoCifrado);
	SecretKeySpec key = new SecretKeySpec(clave.getBytes(), "AES");
	Cipher cipher = Cipher.getInstance("AES");
	cipher.init(Cipher.DECRYPT_MODE, key);
	byte[] descifrado = cipher.doFinal(cifrado);
	return new String(descifrado);
    }
}
