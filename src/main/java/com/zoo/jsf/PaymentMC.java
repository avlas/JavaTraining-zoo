package com.zoo.jsf;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import com.zoo.service.booking.BookingService;

@ManagedBean
public class PaymentMC {
	private String order;
	private String price;
	private int cardNumber;
	private int securityNumber;
	private String expiryDate;

	@Inject
	BookingService bookingService;

	@PostConstruct
	public void init() {
		order = bookingService.getCurrentBooking().orderToString();
		price = String.valueOf(bookingService.getCurrentBooking().getPrice());
	}

	public String payment() {
		bookingService.saveBooking(bookingService.getCurrentBooking());
		return Boolean.TRUE.toString();
	}

	// Getters / Setters
	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public int getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}

	public int getSecurityNumber() {
		return securityNumber;
	}

	public void setSecurityNumber(int securityNumber) {
		this.securityNumber = securityNumber;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
}
