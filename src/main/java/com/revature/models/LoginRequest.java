package com.revature.models;

public class LoginRequest {
	// data will come in as a signed JSON web token, a JWS
	// the header will contain the encrypting algorithm
	// the body will contain the payload
	// that body will be decrypted into this LoginRequest
	
	private String username;
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoginRequest other = (LoginRequest) obj;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "LoginRequest [username=" + username + ", password=" + password + "]";
	}
	public LoginRequest(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public LoginRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	 
	
}
