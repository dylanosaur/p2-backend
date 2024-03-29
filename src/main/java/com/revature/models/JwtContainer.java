package com.revature.models;

public class JwtContainer {

	public String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((token == null) ? 0 : token.hashCode());
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
		JwtContainer other = (JwtContainer) obj;
		if (token == null) {
			if (other.token != null)
				return false;
		} else if (!token.equals(other.token))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "JwtContainer [token=" + token + "]";
	}

	public JwtContainer(String token) {
		super();
		this.token = token;
	}

	public JwtContainer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
