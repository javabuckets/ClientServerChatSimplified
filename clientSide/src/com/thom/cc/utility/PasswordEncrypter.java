package com.thom.cc.utility;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Random;

public class PasswordEncrypter 
{
	private byte[] sha1HashString(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException
	{
		String algorithm = "SHA-1";

		MessageDigest digest = MessageDigest.getInstance(algorithm);

		byte[] myStr = str.getBytes("UTF-8");

		return digest.digest(myStr);
	}

	private String convertByteArrayToHexString(byte[] arrayBytes)
	{
		StringBuffer stringBuffer = new StringBuffer();
		
		for (int i = 0; i < arrayBytes.length; i++)
		{
			stringBuffer.append(Integer.toString((arrayBytes[i] & 0xff) + 0x100, 16).substring(1));
		}
		return stringBuffer.toString();
	}
	
	private String getHashOutput(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException
	{
		return convertByteArrayToHexString(sha1HashString(str));
	}
	
	public String getEncryptedPassword(String password) throws NoSuchAlgorithmException, UnsupportedEncodingException
	{
		String hashOutput = getHashOutput(password);
		
		for (int i = 0; i < 1500; i++)
		{
			hashOutput = getHashOutput(hashOutput);
		}
		
		return getPreSalt() + hashOutput;
	}
	
	private String getRandomSalt()
	{
		Random r = new SecureRandom();
		byte[] salt = new byte[32];
		r.nextBytes(salt);
		
		return convertByteArrayToHexString(salt);
	}
	
	private String getPreSalt()
	{
		return "1001010100100111001010100101010100101";
	}
	
	private String getSalt()
	{
		return getPreSalt() + getRandomSalt();
	}
}