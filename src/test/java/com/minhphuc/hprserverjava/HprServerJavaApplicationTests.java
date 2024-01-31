package com.minhphuc.hprserverjava;

import com.minhphuc.hprserverjava.service.pmp.GenerationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileWriter;
import java.io.IOException;

@SpringBootTest
class HprServerJavaApplicationTests {

	@Autowired
	GenerationService generationService;
	@Test
	void contextLoads() {

		generationService.GenerationCode("hr_furlough","nghỉ phép");
	}

}
