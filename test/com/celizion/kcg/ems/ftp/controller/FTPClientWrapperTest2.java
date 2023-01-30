package com.celizion.kcg.ems.ftp.controller;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.celizion.kcg.ems.ftp.controller.mgmt.FTPClientWrapper;
import com.celizion.kcg.ems.ftp.util.FileUtils;
import com.jcraft.jsch.SftpException;

class FTPClientWrapperTest2 {

	private static FTPClientWrapper ftpClient = new FTPClientWrapper();

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		ftpClient.connect("127.0.0.1", "ftpuser", "good1018");
	}

	@Test
	void testUploadFile() throws Exception {
		ftpClient.makeRemoteDirectory("/bonosftp/test/");
		ftpClient.uploadFile(new File("C:/Temp/WBS_?†µ?•© EMSê°œë°œ_v1.xlsx"), "/bonosftp/test/ems_document.xlsx");
	}

	@Test
	void testDownloadFile() throws Exception {
		ftpClient.downloadFile("/temp/ems_document.xlsx", new File("C:/Temp/WBS_?†µ?•© EMSê°œë°œ_v1_copy.xlsx"));
	}

	@Test
	void testListRemoteFiles() throws IOException, SftpException {
		System.out.println("List Remote Files (specified directory).");
		System.out.println("======================================================");
		for (String path : ftpClient.listRemoteFiles("/", false)) {
			System.out.println(path);
		}
		System.out.println("List Remote Files (specified directory and chile hierarchy files).");
		System.out.println("======================================================");
		for (String path : ftpClient.listRemoteFiles("/utils", true)) {
			System.out.println(path);
		}
	}

	@Test
	void testListFiles() throws IOException {
		System.out.println("List Local Files (specified directory).");
		System.out.println("======================================================");
		for (File file : FileUtils.listFiles(new File("C:\\FTP Folder"), false)) {
			System.out.println(file.getAbsolutePath());
		}
		System.out.println("List Local Files (specified directory and chile hierarchy files).");
		System.out.println("======================================================");
		for (File file : FileUtils.listFiles(new File("C:\\FTP Folder"), true)) {
			System.out.println(file.getAbsolutePath());
		}
	}

}
