package com.celizion.kcg.ems.ftp.config;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.celizion.kcg.ems.ftp.config.FTPJobLoader;
import com.celizion.kcg.ems.ftp.config.FTPJobScheduler;
import com.celizion.kcg.ems.ftp.controller.mgmt.FTPConnectionPool;

class FTPJobLoaderTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
//		LoginInfoManager.instance.add("127.0.0.1", "ftpuser", "good1018");
//		LoginInfoManager.instance.add("localhost", "ftpuser", "good1018");
	}

	@Test
	void testLoad() throws IOException, InterruptedException {
		// FTPJobLoader.instance.load(new File(FTPJobLoaderTest.class.getResource("uploadtest.json").getPath()));
		// FTPJobLoader.instance.load(new File(FTPJobLoaderTest.class.getResource("uploadtest2.json").getPath()));
		FTPJobLoader.instance.load(new File(FTPJobLoaderTest.class.getResource("downloadtest3.json").getPath()));
		//  FTPJobLoader.instance.load(new File(FTPJobLoaderTest.class.getResource("downloadtest2.json").getPath()));
		
		FTPConnectionPool.instance.startUnusedFTPClientRemover();
		FTPJobScheduler.instance.startAllSchedules();
		
		Thread.sleep(3600000);
	}

}
