package com.zoo.service.booking;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.zoo.data.booking.BookingDao;
import com.zoo.model.Booking;
import com.zoo.service.user.UserService;

@Stateless
public class BookingServiceImpl implements BookingService {

	@Inject
	private BookingDao bookingDao;

	@Inject
	private BookingHolder bookingHolder;

	@Inject
	private UserService userService;

	@Override
	public Booking createBooking(int nbAdults, int nbChildren, int nbReduced, int nbGroup) {
		Booking booking = new Booking();
		booking.setNbAdults(nbAdults);
		booking.setNbChildren(nbChildren);
		booking.setNbReduced(nbReduced);
		booking.setNbGroups(nbGroup);
		if (userService.getCurrentUser() != null) {
			booking.setEmail(userService.getCurrentUser().getEmail());
		}
		booking.calculatePrice();
		return booking;
	}

	@Override
	public void saveBooking(Booking booking) {
		bookingDao.persist(booking);
	}

	@Override
	public void removeBooking(Booking booking) {
		bookingDao.remove(booking);
	}

	@Override
	public Booking findBookingById(int id) {
		return bookingDao.findById(id);
	}

	@Override
	public Collection<Booking> findAllBooking() {
		return bookingDao.findAll();
	}

	@Override
	public Booking getCurrentBooking() {
		return bookingHolder.getBooking();
	}

	@Override
	public void setCurrentBooking(Booking booking) {
		bookingHolder.setBooking(booking);

	}

}
