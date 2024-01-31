package com.minhphuc.hprserverjava;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("package com.minhphuc.hprserverjava.mapper")
public class HprServerJavaApplication {

	public static void main(String[] args) {
		StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
		encryptor.setPassword("mp-secret-key");
		SpringApplication.run(HprServerJavaApplication.class, args);
	}

}
