package java8.ex01;

import org.apache.commons.codec.digest.DigestUtils;

public class TestDigestUtils {

	public static void main(String[] args) {

		String password = "coucou1&";
		String encodedPassword = DigestUtils.sha512Hex(password);
				System.out.println(encodedPassword);
				
		password = "coucou2&";
		System.out.println(DigestUtils.sha512Hex(password));

	}

}
