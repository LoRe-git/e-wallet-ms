package org.ewallet.walletusers.dto;

import java.math.BigDecimal;

public class WalletInfoDto {

	private Long id;
	private String walletName;
	private String walletDescription;
	private BigDecimal balance;
	private Long userId;
	
//    private UserDto user;

    public WalletInfoDto() {
    	super();
    }
    
	public WalletInfoDto(Long id, String walletName,String walletDescription,BigDecimal balance, UserDto user) {
		super();
		this.id = id;
		this.walletName = walletName;
		this.walletDescription = walletDescription;
		this.balance = balance;
//		this.user = user;
		this.userId = user.getId();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getWalletName() {
		return walletName;
	}

	public void setWalletName(String walletName) {
		this.walletName = walletName;
	}

	
	public String getWalletDescription() {
		return walletDescription;
	}

	public void setWalletDescription(String walletDescription) {
		this.walletDescription = walletDescription;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

//	public UserDto getUser() {
//		return user;
//	}
//
//	public void setUser(UserDto user) {
//		this.user = user;
//	}

	
//	@Override
//	public String toString() {
//		return "Wallet [id=" + id + ", walletName=" + walletName + ", walletDescription=" + walletDescription +  ", balance=" + balance + ", user=" + user + "]";
//	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

}
