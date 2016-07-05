package com.sm24soft.encryption;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

import org.apache.commons.codec.binary.Base64;

public class Encrypter {

	private static final byte[] SALT = new byte[] { (byte) 0x1a, (byte) 0x22, (byte) 0x0b, (byte) 0x83, (byte) 0x42,
			(byte) 0xd8, (byte) 0xee, (byte) 0x8c, };
	private static final String METHOD = "PBEWithMD5AndDES";

	private static final int iterationCount = 1000;

	private static final PBEParameterSpec pbeParamSpec = new PBEParameterSpec(SALT, iterationCount);

	private PBEKeySpec pbeKeySpec;

	SecretKey pbeKey;
	Cipher pbeCipher;

	public Encrypter(String key) {
		pbeKeySpec = new PBEKeySpec(key.toCharArray());
	}

	public String encrypt(String plaintext) {
		SecretKeyFactory keyFac;
		SecretKey pbeKey;
		Cipher pbeCipher;
		try {
			keyFac = SecretKeyFactory.getInstance(METHOD);
			pbeKey = keyFac.generateSecret(pbeKeySpec);
			pbeCipher = Cipher.getInstance(METHOD);
			pbeCipher.init(Cipher.ENCRYPT_MODE, pbeKey, pbeParamSpec);
			return new String(Base64.encodeBase64(pbeCipher.doFinal(plaintext.getBytes())));
		} catch (NoSuchAlgorithmException e) {
			throw new IllegalStateException(e);
		} catch (InvalidKeySpecException e) {
			throw new IllegalStateException(e);
		} catch (NoSuchPaddingException e) {
			throw new IllegalStateException(e);
		} catch (InvalidKeyException e) {
			throw new IllegalStateException(e);
		} catch (InvalidAlgorithmParameterException e) {
			throw new IllegalStateException(e);
		} catch (IllegalBlockSizeException e) {
			throw new IllegalStateException(e);
		} catch (BadPaddingException e) {
			throw new IllegalStateException(e);
		}
	}

	public String decrypt(String encrypted) {
		SecretKeyFactory keyFac;
		SecretKey pbeKey;
		Cipher pbeCipher;

		try {
			keyFac = SecretKeyFactory.getInstance(METHOD);
			pbeKey = keyFac.generateSecret(pbeKeySpec);
			pbeCipher = Cipher.getInstance(METHOD);
			pbeCipher.init(Cipher.DECRYPT_MODE, pbeKey, pbeParamSpec);
			return new String(pbeCipher.doFinal(Base64.decodeBase64(encrypted.getBytes())));
		} catch (NoSuchAlgorithmException e) {
			throw new IllegalStateException(e);
		} catch (InvalidKeySpecException e) {
			throw new IllegalStateException(e);
		} catch (NoSuchPaddingException e) {
			throw new IllegalStateException(e);
		} catch (InvalidKeyException e) {
			throw new IllegalStateException(e);
		} catch (InvalidAlgorithmParameterException e) {
			throw new IllegalStateException(e);
		} catch (IllegalBlockSizeException e) {
			throw new IllegalStateException(e);
		} catch (BadPaddingException e) {
			throw new IllegalStateException(e);
		}
	}

}
