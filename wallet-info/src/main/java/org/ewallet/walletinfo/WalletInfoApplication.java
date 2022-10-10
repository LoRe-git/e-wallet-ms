package org.ewallet.walletinfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class WalletInfoApplication {

	public static void main(String[] args) {
		SpringApplication.run(WalletInfoApplication.class, args);
	}

}
