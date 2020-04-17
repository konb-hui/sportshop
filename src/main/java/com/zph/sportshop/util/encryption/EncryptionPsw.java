package com.zph.sportshop.util.encryption;

import org.apache.commons.codec.digest.DigestUtils;

public final class EncryptionPsw {
	public static void main(String[] args) {
		System.out.println(getPassword("12345678"));
	}
	public static String getPassword(String password) {
		return DigestUtils.md5Hex(DigestUtils.md5Hex(password) + SystemStaticService.SOLT);
	}
	public class SystemStaticService {
	    public static final String SOLT="konb";
	}
}
