package com.modelo;

/**
 * Excepción lanzada cuando la clave de AES no cumple con el largo adecuado de 
 * 16 caracteres.
 * @author Jorge Silva Borda
 */
public class AESKeyException extends Exception {
    private final int largoActual;
    public AESKeyException(int largoActual){
	this.largoActual = largoActual;
    }
    
    @Override
    public String toString(){
	return "El largo de la clave generada es inválida (" + this.largoActual + " caracteres). Debe contener exactamente 16 caracteres.";
    }
}
