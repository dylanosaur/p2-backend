package com.revature.models;

public class UserUpdates {

	private User user;
	private CreditCard creditCard;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public CreditCard getCreditCard() {
		return creditCard;
	}
	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((creditCard == null) ? 0 : creditCard.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		UserUpdates other = (UserUpdates) obj;
		if (creditCard == null) {
			if (other.creditCard != null)
				return false;
		} else if (!creditCard.equals(other.creditCard))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "UserUpdates [user=" + user + ", creditCard=" + creditCard + "]";
	}
	public UserUpdates(User user, CreditCard creditCard) {
		super();
		this.user = user;
		this.creditCard = creditCard;
	}
	public UserUpdates() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
