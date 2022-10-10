package org.ewallet.serviceregistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class WalletServiceRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(WalletServiceRegistryApplication.class, args);
	}

}
