package org.ewallet.walletusers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients("org.ewallet.walletusers.feign")
public class WalletUsersApplication {

	public static void main(String[] args) {
		SpringApplication.run(WalletUsersApplication.class, args);
	}

}
