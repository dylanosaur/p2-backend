package com.revature.models;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="items")
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;
	private BigDecimal price;
	private String imgPath;
	private String thumbnailPath;
	private String clothingType;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public String getThumbnailPath() {
		return thumbnailPath;
	}

	public void setThumbnailPath(String thumbnailPath) {
		this.thumbnailPath = thumbnailPath;
	}

	public String getClothingType() {
		return clothingType;
	}

	public void setClothingType(String clothingType) {
		this.clothingType = clothingType;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clothingType == null) ? 0 : clothingType.hashCode());
		result = prime * result + id;
		result = prime * result + ((imgPath == null) ? 0 : imgPath.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((thumbnailPath == null) ? 0 : thumbnailPath.hashCode());
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
		Item other = (Item) obj;
		if (clothingType == null) {
			if (other.clothingType != null)
				return false;
		} else if (!clothingType.equals(other.clothingType))
			return false;
		if (id != other.id)
			return false;
		if (imgPath == null) {
			if (other.imgPath != null)
				return false;
		} else if (!imgPath.equals(other.imgPath))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (thumbnailPath == null) {
			if (other.thumbnailPath != null)
				return false;
		} else if (!thumbnailPath.equals(other.thumbnailPath))
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
		return "Item [id=" + id + ", name=" + name + ", price=" + price + ", imgPath=" + imgPath + ", thumbnailPath="
				+ thumbnailPath + ", clothingType=" + clothingType + ", user=" + user + "]";
	}

	public Item(int id, String name, BigDecimal price, String imgPath, String thumbnailPath, String clothingType,
			User user) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.imgPath = imgPath;
		this.thumbnailPath = thumbnailPath;
		this.clothingType = clothingType;
		this.user = user;
	}

	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}


 
}
