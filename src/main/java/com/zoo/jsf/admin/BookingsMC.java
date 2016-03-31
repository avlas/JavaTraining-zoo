package com.zoo.jsf.admin;

import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import com.zoo.model.Booking;
import com.zoo.service.booking.BookingService;

@ManagedBean
public class BookingsMC {

	private int id;
	private Collection<Booking> bookings;

	@Inject
	BookingService bookingService;

	@PostConstruct
	public void init() {
		bookings = bookingService.findAllBooking();
	}

	public String deleteBooking() {
		Booking booking = bookingService.findBookingById(id);
		bookingService.removeBooking(booking);
		return "false";
	}

	// Getters /Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Collection<Booking> getBookings() {
		return bookings;
	}
}
