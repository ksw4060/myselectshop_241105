package com.example.mySelectShop.demo;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableScheduling
@EnableJpaAuditing
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		Dotenv dotenv = Dotenv.configure()
				.directory("./")  // .env 파일의 경로를 명시적으로 설정
				.ignoreIfMissing()
				.load();

		dotenv.entries().forEach(entry -> {
			// 시스템 환경 변수로 설정되어 있지 않은 경우에만 시스템 속성으로 설정
			if (System.getenv(entry.getKey()) == null) {
				System.setProperty(entry.getKey(), entry.getValue());
			}
		});

		SpringApplication.run(DemoApplication.class, args);
	}

}
