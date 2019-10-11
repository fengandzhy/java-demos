package org.zhouhy.java.poi.excel.generate;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class GenerateExcelFileTest {

	@BeforeAll
    public static void init() {
        System.out.println("ø™ º≤‚ ‘-----------------");
    }
	
	@Test
	void testSample1() throws Exception {
		GenerateExcelFile generateExcelFile = new GenerateExcelFile();
		generateExcelFile.sample1();
	}
	
	@Test
	void testSample2() throws Exception {
		GenerateExcelFile generateExcelFile = new GenerateExcelFile();
		generateExcelFile.sample2();
	}
	
	@AfterAll
    public static void after() {
        System.out.println("≤‚ ‘Ω· ¯-----------------");
    }

}
