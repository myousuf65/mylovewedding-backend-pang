package xyz.yousuf.MyLoveWedding.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.yousuf.MyLoveWedding.BookingDto;
import xyz.yousuf.MyLoveWedding.entities.Booking;
import xyz.yousuf.MyLoveWedding.entities.Customer;
import xyz.yousuf.MyLoveWedding.entities.Venue;
import xyz.yousuf.MyLoveWedding.repository.BookingRepository;
import xyz.yousuf.MyLoveWedding.repository.CustomerRepository;
import xyz.yousuf.MyLoveWedding.repository.VenueRepository;

import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private VenueRepository venueRepository;


    public Booking addBooking(BookingDto bookingDto){

        // get customer id, if no create customer record
        Customer customer = customerRepository.findByEmail(bookingDto.getEmail());
        Optional<Venue> venue = venueRepository.findById(Long.valueOf(bookingDto.getVenue()));
        Booking booking = new Booking();
        if(customer == null){
            System.out.println("No previous record for this customer");

            Customer newCustomer = new Customer();
            newCustomer.setName(bookingDto.getName());
            newCustomer.setEmail(bookingDto.getEmail());
            newCustomer.setPhoneNumber(bookingDto.getPhone());

            customerRepository.save(newCustomer);
            customerRepository.flush();


            booking.setCustomer(newCustomer);
            booking.setTiming(bookingDto.getTimeslot());
            booking.setVenue(venue.orElse(null));
            Booking savedBooking = bookingRepository.save(booking);
            return savedBooking;

        } else{

            booking.setCustomer(customer);
            booking.setTiming(bookingDto.getTimeslot());
            booking.setVenue(venue.orElse(null));


            Booking savedBooking = bookingRepository.save(booking);
            return savedBooking;

        }


    }

}
