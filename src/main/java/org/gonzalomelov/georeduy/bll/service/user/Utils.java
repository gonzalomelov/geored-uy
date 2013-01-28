package org.gonzalomelov.georeduy.bll.service.user;

import org.apache.commons.lang3.RandomStringUtils;

public class Utils {
	public static String generatePassword(){
		return RandomStringUtils.random(10,"1234567890abcdefghijklmnopkrstuvwxyz");
	}
}
