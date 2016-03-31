package com.zoo.jsf;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import com.zoo.service.booking.BookingService;

@ManagedBean
public class TicketsMC {

	private int adult;
	private int child;
	private int reduced;
	private int group;

	@Inject
	BookingService bookingService;

	// If at least one ticket is ordered return true to lead to the payment page
	public String payment() {

		if (adult > 0 || child > 0 || reduced > 0 || group > 0) {
			bookingService.setCurrentBooking(bookingService.createBooking(adult, child, reduced, group));
			return Boolean.TRUE.toString();
		} else {
			return Boolean.FALSE.toString();
		}
	}

	// Getters / Setters
	public int getAdult() {
		if (bookingService.getCurrentBooking() != null) {
			return bookingService.getCurrentBooking().getNbAdults();
		}
		return adult;
	}

	public void setAdult(int adult) {
		this.adult = adult;
	}

	public int getChild() {
		if (bookingService.getCurrentBooking() != null) {
			return bookingService.getCurrentBooking().getNbChildren();
		}
		return child;
	}

	public void setChild(int child) {
		this.child = child;
	}

	public int getReduced() {
		if (bookingService.getCurrentBooking() != null) {
			return bookingService.getCurrentBooking().getNbReduced();
		}
		return reduced;
	}

	public void setReduced(int reduced) {
		this.reduced = reduced;
	}

	public int getGroup() {
		if (bookingService.getCurrentBooking() != null) {
			return bookingService.getCurrentBooking().getNbGroups();
		}
		return group;
	}

	public void setGroup(int group) {
		this.group = group;
	}
}
