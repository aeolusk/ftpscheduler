package com.celizion.kcg.ems.ftp.config;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.celizion.kcg.ems.ftp.config.ConfigKeywords;
import com.celizion.kcg.ems.ftp.config.InvalidConfigFormatException;
import com.celizion.kcg.ems.ftp.config.ScheduleContext;

class ConfigUtilsTest implements ConfigKeywords {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@Test
	void testTranslateReserved() throws InvalidConfigFormatException {
		ScheduleContext context = new ScheduleContext();
		String input = "/FTP Folder/temp/{SIMPLEDATEFORMAT:yyyyMMddYYHHMM}/{SOURCEFILE}";

		context.setSourceFilePath("/bono/test.txt");

		System.out.println(context.translate(input));
	}

}
