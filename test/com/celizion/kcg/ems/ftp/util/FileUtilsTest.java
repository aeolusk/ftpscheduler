package com.celizion.kcg.ems.ftp.util;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.celizion.kcg.ems.ftp.util.FileUtils;

class FileUtilsTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@Test
	void testGetDirectory() {
		System.out.println(FileUtils.getDirectory("/user/bono/test/a.txt"));
		System.out.println(FileUtils.getDirectory("\\user\\bono\\test\\b.txt"));
	}

	@Test
	void testGetFilename() {
		System.out.println(FileUtils.getFilename("/user/bono/test/a.txt"));
		System.out.println(FileUtils.getFilename("\\user\\bono\\test\\b.txt"));
	}

}
