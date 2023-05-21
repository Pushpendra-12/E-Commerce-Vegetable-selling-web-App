package org.vegetableApp.dto;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


import lombok.Data;

@Component("loginToken")
@Scope("session")
@Data
public class LoginToken {
	private String userName;
	private String password;
	
	public LoginToken() {
		
	}

	public LoginToken(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

}
