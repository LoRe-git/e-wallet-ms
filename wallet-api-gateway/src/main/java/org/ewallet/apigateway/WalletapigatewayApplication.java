package org.ewallet.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class WalletapigatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(WalletapigatewayApplication.class, args);
	}

}
