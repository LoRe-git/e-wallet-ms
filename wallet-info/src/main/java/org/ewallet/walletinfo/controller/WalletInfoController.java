package org.ewallet.walletinfo.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;

import org.ewallet.walletinfo.dto.TransactionType;
import org.ewallet.walletinfo.dto.UserDto;
import org.ewallet.walletinfo.dto.WalletInfoDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/wallet")
@RestController
@CrossOrigin(origins = {"http://localhost:3000"})
public class WalletInfoController {
	
	private static List<WalletInfoDto> WALLETS = new ArrayList<>();
	static {
		
		UserDto user = new UserDto();
		user.setId(1l);
		user.setUserName("user");
		WALLETS.add(new WalletInfoDto(1l, "Wallet 1", "Wallet 1 Desc", new BigDecimal(100), user));
		WALLETS.add(new WalletInfoDto(2l, "Wallet 2", "Wallet 2 Desc", new BigDecimal(200), user));
	}
	
	@GetMapping("/{id}")
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	public WalletInfoDto getWallet(@PathVariable("id") Long id) throws Exception {
		return WALLETS.get(id.intValue()-1);
	}
	
	@GetMapping("/")
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	public List<WalletInfoDto> getWallets() throws Exception {
		return WALLETS;
	}
	
	@PostMapping("/create")
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	@Consumes(MediaType.APPLICATION_JSON_VALUE)
	public WalletInfoDto create(@RequestBody WalletInfoDto newWalletDto) throws Exception {
		WALLETS.add(newWalletDto);
		return newWalletDto;
	}
	
	@PutMapping("/update/{id}")
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	@Consumes(MediaType.APPLICATION_JSON_VALUE)
	public WalletInfoDto updateBalance(@PathVariable("id") Long id, @RequestParam TransactionType type, @RequestParam BigDecimal amount) throws Exception {
		if(TransactionType.CREDIT.equals(type)) {
			WALLETS.get(id.intValue()-1).setBalance(WALLETS.get(id.intValue()-1).getBalance().add(amount));
		} else {
			WALLETS.get(id.intValue()-1).setBalance(WALLETS.get(id.intValue()-1).getBalance().subtract(amount));
		}
		return WALLETS.get(id.intValue()-1);
	}
}
