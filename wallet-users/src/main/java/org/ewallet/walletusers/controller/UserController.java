package org.ewallet.walletusers.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;

import org.ewallet.walletusers.dto.UserDto;
import org.ewallet.walletusers.dto.WalletInfoDto;
import org.ewallet.walletusers.feign.WalletInfoServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/user")
@RestController
@CrossOrigin(origins = {"http://localhost:3000"})
public class UserController {
	
	@Autowired
	WalletInfoServiceProxy walletInfoServiceProxy;
	//	private RestTemplate restTemplate;
	
	private static List<UserDto> USERS = new ArrayList<>();
	static {
		USERS.add(new UserDto(1l, "USER1"));
		USERS.add(new UserDto(2l, "USER2"));
	}
	
	@GetMapping("/{id}")
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	public UserDto getUser(@PathVariable("id") Long id) throws Exception {
		List<WalletInfoDto> wallets = new ArrayList<>();
//		wallets.add(restTemplate.getForObject("http://WALLET-INFO/wallet/1", WalletInfoDto.class));
		wallets.add(walletInfoServiceProxy.getWalletById(id));
		USERS.get(id.intValue()-1).setWallets(wallets);
		return USERS.get(id.intValue()-1);
	}
	
	@GetMapping("/")
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	public List<UserDto> getUsers() throws Exception {
		return USERS;
	}
	
	@PostMapping("/create")
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	@Consumes(MediaType.APPLICATION_JSON_VALUE)
	public UserDto create(@RequestBody UserDto userDto) throws Exception {
		USERS.add(userDto);
		return userDto;
	}
	
//	@PutMapping("/update/{id}")
//	@Produces(MediaType.APPLICATION_JSON_VALUE)
//	@Consumes(MediaType.APPLICATION_JSON_VALUE)
//	public WalletInfoDto updateBalance(@PathVariable("id") Long id, @RequestParam TransactionType type, @RequestParam BigDecimal amount) throws Exception {
//		if(TransactionType.CREDIT.equals(type)) {
//			USERS.get(id.intValue()).setBalance(USERS.get(id.intValue()).getBalance().add(amount));
//		} else {
//			USERS.get(id.intValue()).setBalance(USERS.get(id.intValue()).getBalance().subtract(amount));
//		}
//		return USERS.get(id.intValue());
//	}
}
