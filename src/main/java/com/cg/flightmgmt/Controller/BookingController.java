package com.cg.flightmgmt.Controller;

import java.math.BigInteger;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.flightmgmt.Entity.Booking;
import com.cg.flightmgmt.Entity.Passenger;
import com.cg.flightmgmt.Service.BookingService;

@RestController
public class BookingController {

	private static final Logger logger = LoggerFactory.getLogger(BookingController.class);
	
	@Autowired
	private BookingService bookingService;
		
	@PostMapping("/booking")
	public ResponseEntity<?> addBooking(@RequestBody Booking booking)
	{
		 bookingService.validateBooking(booking); 
		Booking addedbooking = bookingService.addBooking(booking);
		return ResponseEntity.ok(addedbooking);
	}
	
	@PutMapping("/booking/{id}")
	public ResponseEntity<?> updateBooking(@PathVariable("id") @RequestBody Booking booking)
	{
		 bookingService.validateBooking(booking); 
		Booking updatedbooking = bookingService.modifyBooking(booking);
		return ResponseEntity.ok(updatedbooking);
	}
	
	@GetMapping("/booking/{id}")
	public ResponseEntity<?> fetchById(@PathVariable("id") BigInteger userId)
	{
		List<Booking> fetchedbooking = bookingService.viewBooking(userId);
		return ResponseEntity.ok(fetchedbooking);
	}
	
	@GetMapping("/booking")
	public ResponseEntity<?> fetchAllBookings()
	{
		List<Booking> allbooking= bookingService.viewBookingList();
		return ResponseEntity.ok(allbooking);
	}
	
	@DeleteMapping("/booking/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") BigInteger bookingId)
    {
		 bookingService.deleteBooking(bookingId);
		return ResponseEntity.ok("deleted successfully");
    }
	
	
}
