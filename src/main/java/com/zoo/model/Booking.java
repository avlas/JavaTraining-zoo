package com.zoo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Booking {

	private static final String UNKNOW_EMAIL = "unknow@unknow.xxx";
	private static final String LINE_SEPARATOR = System.getProperty("line.separator");

	@Id
	@GeneratedValue
	private int id;
	private int nbAdults;
	private int nbChildren;
	private int nbReduced;
	private int nbGroups;
	private int price;
	private String date;
	private String email;

	public Booking() {
		this.date = new Date().toString();
		this.email = UNKNOW_EMAIL;
	}

	public String orderToString() {
		String string = "";
		if (nbAdults > 0) {
			string += "Adults : " + nbAdults + LINE_SEPARATOR;
		}
		if (nbChildren > 0) {
			string += "Children : " + nbChildren + LINE_SEPARATOR;
		}
		if (nbReduced > 0) {
			string += "Reduced : " + nbReduced + LINE_SEPARATOR;
		}
		if (nbGroups > 0) {
			string += "Group : " + nbGroups + LINE_SEPARATOR;
		}
		return string;
	}

	public void calculatePrice() {
		this.price = (nbAdults * 26) + (nbChildren * 7) + (nbReduced * 13) + (nbGroups * 20);
	}

	// Getters / Setters
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getNbAdults() {
		return nbAdults;
	}

	public void setNbAdults(int nbAdults) {
		this.nbAdults = nbAdults;
	}

	public int getNbChildren() {
		return nbChildren;
	}

	public void setNbChildren(int nbChildren) {
		this.nbChildren = nbChildren;
	}

	public int getNbReduced() {
		return nbReduced;
	}

	public void setNbReduced(int nbReduced) {
		this.nbReduced = nbReduced;
	}

	public int getNbGroups() {
		return nbGroups;
	}

	public void setNbGroups(int nbGroups) {
		this.nbGroups = nbGroups;
	}
}
