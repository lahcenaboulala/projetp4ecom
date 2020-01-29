package com.youcode.ecommerce.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDTO {

	@NotNull
	@NotEmpty
	@Size(min = 3, max = 52)
	private String email;

	@NotNull
	@NotEmpty
	@Size(min = 6, max = 52)
	private String password;

	@NotNull
	@NotEmpty
	private String passwordRepeat;

	public UserDTO() {

	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordRepeat() {
		return passwordRepeat;
	}

	public void setPasswordRepeat(String passwordRepeat) {
		this.passwordRepeat = passwordRepeat;
	}

}
