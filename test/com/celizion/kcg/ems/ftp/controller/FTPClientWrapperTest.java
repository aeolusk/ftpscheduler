package com.celizion.kcg.ems.ftp.controller;

import java.io.File;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.celizion.kcg.ems.ftp.util.FileUtils;

class FTPClientWrapperTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@Test
	void testGetDirectory() {
		System.out.println(FileUtils.getDirectory("c:\\bono\\test.xml"));
		System.out.println(FileUtils.getParentDirectory("/usr/home/bono/"));
		System.out.println(FileUtils.getParentDirectory("/usr/home/bono"));
	}
	
	@Test
	void testMakeDirectory() {
		FileUtils.makeDirectory(new File("C:/Temp/bono/test/cm"));
	}

}
