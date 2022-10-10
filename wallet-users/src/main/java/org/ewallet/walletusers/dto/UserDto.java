package org.ewallet.walletusers.dto;

import java.util.List;

public class UserDto {

	private Long id;
	private String userName;

	private List<WalletInfoDto> wallets;
	
	public UserDto() {
		super();
	}

	public UserDto(Long id, String userName) {
		super();
		this.id = id;
		this.userName = userName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<WalletInfoDto> getWallets() {
		return wallets;
	}

	public void setWallets(List<WalletInfoDto> wallets) {
		this.wallets = wallets;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + "]";
	}


}
