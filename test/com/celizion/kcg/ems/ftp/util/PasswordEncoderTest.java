package com.celizion.kcg.ems.ftp.util;

import java.nio.charset.StandardCharsets;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.celizion.kcg.ems.ftp.util.PasswordEncoder;

class PasswordEncoderTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@Test
	void testEncrypt() throws Exception {
		final String commonPassword = "TotalWingsSecureVersion1.0";
		String encryptPassword = PasswordEncoder.encrypt("good1018".getBytes(StandardCharsets.UTF_8), commonPassword);
		System.out.println("encryptPassword = [" + encryptPassword + "]");

		String password = PasswordEncoder.decrypt(encryptPassword, commonPassword);
		System.out.println("password = [" + password + "]");
		// System.out.println("password = [" + PasswordEncoder.decrypt("wDJj+fDMsjX26EBKgO/gSOVwQT7k+0gzKdDg5xb4Z5v0T9FWKD6fnY16nMVxm8lK/Jc/z6eK1t0=") + "]");
	}

}
