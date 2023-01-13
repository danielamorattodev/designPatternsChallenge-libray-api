package one.dio.designPatternsChallenglibrayapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class DesignPatternsChallengLibrayApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesignPatternsChallengLibrayApiApplication.class, args);
	}

}
