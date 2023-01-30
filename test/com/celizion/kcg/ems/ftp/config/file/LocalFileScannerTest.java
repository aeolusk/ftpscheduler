package com.celizion.kcg.ems.ftp.config.file;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.celizion.kcg.ems.ftp.config.InvalidConfigFormatException;
import com.celizion.kcg.ems.ftp.config.file.LocalFileScanner;

class LocalFileScannerTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@Test
	void testScan() throws InvalidConfigFormatException, IOException {
		LocalFileScanner fileLoader = new LocalFileScanner("filePattern:/temp/bono/test/,\\d+\\.\\d+\\.\\d+.txt");

		for (File file : fileLoader.scan()) {
			System.out.println(file.getAbsolutePath());
		}
	}

}
