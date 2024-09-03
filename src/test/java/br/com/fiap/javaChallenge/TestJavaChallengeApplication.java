package br.com.fiap.javaChallenge;

import org.springframework.boot.SpringApplication;

public class TestJavaChallengeApplication {

	public static void main(String[] args) {
		SpringApplication.from(JavaChallengeApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
