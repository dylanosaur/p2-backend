package com.revature.models;

public class SignInResponse {

	private CreditCard myCreditCard;
	private User myUser;
	public CreditCard getMyCreditCard() {
		return myCreditCard;
	}
	public void setMyCreditCard(CreditCard myCreditCard) {
		this.myCreditCard = myCreditCard;
	}
	public User getMyUser() {
		return myUser;
	}
	public void setMyUser(User myUser) {
		this.myUser = myUser;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((myCreditCard == null) ? 0 : myCreditCard.hashCode());
		result = prime * result + ((myUser == null) ? 0 : myUser.hashCode());
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
		SignInResponse other = (SignInResponse) obj;
		if (myCreditCard == null) {
			if (other.myCreditCard != null)
				return false;
		} else if (!myCreditCard.equals(other.myCreditCard))
			return false;
		if (myUser == null) {
			if (other.myUser != null)
				return false;
		} else if (!myUser.equals(other.myUser))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "SignInResponse [myCreditCard=" + myCreditCard + ", myUser=" + myUser + "]";
	}
	public SignInResponse(CreditCard myCreditCard, User myUser) {
		super();
		this.myCreditCard = myCreditCard;
		this.myUser = myUser;
	}
	public SignInResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
