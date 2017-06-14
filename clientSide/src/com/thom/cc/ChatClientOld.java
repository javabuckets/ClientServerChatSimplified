package com.thom.cc;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import com.thom.cc.utility.PasswordEncrypter;

public class ChatClientOld
{
	public static void main(String[] args) 
	{
		try 
		{
			PasswordEncrypter passwordEncrypter = new PasswordEncrypter();
			System.out.println(passwordEncrypter.getEncryptedPassword(""));
		}
		catch (NoSuchAlgorithmException | UnsupportedEncodingException e) 
		{
			e.printStackTrace();
		}
	}
}