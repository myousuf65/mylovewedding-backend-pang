package xyz.yousuf.MyLoveWedding.service;

import org.springframework.aot.hint.predicate.ProxyHintsPredicates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.yousuf.MyLoveWedding.BookingDto;
import xyz.yousuf.MyLoveWedding.entities.*;
import xyz.yousuf.MyLoveWedding.repository.*;

import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private VenueRepository venueRepository;
    @Autowired
    private LawyerRepository lawyerRepository;
    @Autowired
    private StylistRepository stylistRepository;
    @Autowired
    private PhotographerRepository photographerRepository;


    public Booking addBooking(BookingDto bookingDto){

        // get customer id, if no create customer record
        Customer customer = customerRepository.findByEmail(bookingDto.getEmail());
        Optional<Venue> venue = venueRepository.findById(Long.valueOf(bookingDto.getVenueId()));

        Optional<Lawyer> lawyer =  lawyerRepository.findById(Long.valueOf(bookingDto.getLawyerId()));
        Optional<Stylist> stylist = stylistRepository.findById(Long.valueOf(bookingDto.getStylistId()));
        Optional<Photographer> photographer = photographerRepository.findById(Long.valueOf(bookingDto.getPhotographerId()));


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
            booking.setVenue(venue.orElse(null));
            booking.setDate(bookingDto.getDate());
            booking.setLawyer(lawyer.get());
            booking.setPhotographer(photographer.get());
            booking.setStylist(stylist.get());
            Booking savedBooking = bookingRepository.save(booking);
            bookingRepository.flush();
            return savedBooking;

        } else{

            booking.setCustomer(customer);
            booking.setLawyer(lawyer.get());
            booking.setPhotographer(photographer.get());
            booking.setStylist(stylist.get());
            booking.setVenue(venue.orElse(null));
            booking.setDate(bookingDto.getDate());

            Booking savedBooking = bookingRepository.save(booking);
            bookingRepository.flush();
            return savedBooking;

        }


    }

}
