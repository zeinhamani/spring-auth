package com.zein.auth.Jwt.Authentication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class JwtAuthenticationApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwtAuthenticationApplication.class, args);
	}

	/*@Bean
	public CommandLineRunner commandLineRunner(AuthenticationService service){
		return args -> {
			var zein = RegisterRequest.builder()
					.firstname("Zein")
					.lastname("Hamani")
					.email("zein@zein.com")
					.password("zein")
					.role(ADMIN)
					.build();
			System.out.println("Zein Token: " + service.register(zein).getToken());
		};
	}*/

}
