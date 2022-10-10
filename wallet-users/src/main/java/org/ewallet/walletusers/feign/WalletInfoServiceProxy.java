package org.ewallet.walletusers.feign;

import org.ewallet.walletusers.dto.WalletInfoDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="WALLET-INFO", url="localhost:9091")
public interface WalletInfoServiceProxy {
	@GetMapping("/wallet/{id}")
	public WalletInfoDto getWalletById(@PathVariable("id") Long id);
}
