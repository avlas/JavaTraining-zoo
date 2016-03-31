package com.zoo.service.booking;

import java.util.Collection;

import com.zoo.model.Booking;

public interface BookingService {
	Booking createBooking(int nbAdults, int nbChildren, int nbReduced, int nbGroup);

	void saveBooking(Booking booking);

	void removeBooking(Booking booking);

	Booking findBookingById(int id);

	Collection<Booking> findAllBooking();

	Booking getCurrentBooking();
	
	void setCurrentBooking(Booking booking);
}
