package xyz.yousuf.MyLoveWedding.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.yousuf.MyLoveWedding.entities.Venue;
import xyz.yousuf.MyLoveWedding.repository.VenueRepository;

import java.util.List;
import java.util.Optional;

@Service
public class VenueService {

    @Autowired
    private VenueRepository repository;


    public  List<Venue> getAllVenues(){
        return repository.findAll();
    }

    public String addVenue(Venue venue) {
        repository.save(venue);
        return "success";
    }

    public Venue modifyVenue(Venue venue) {
        Long id = venue.getVenueId();
        Optional<Venue> tempVenue = repository.findById(id);

        if (tempVenue.isPresent()) {
            repository.save(venue);
            return venue; // Return the updated venue
        } else {
            throw new IllegalArgumentException("Venue with ID " + id + " does not exist.");
        }
    }

    public String deleteBooking(Long bookingId) {
        // Check if the booking exists in the repository
        Optional<Venue> booking = repository.findById(bookingId);

        if (booking.isPresent()) {
            // If booking exists, delete it
            repository.deleteById(bookingId);
            System.out.println("Booking with ID " + bookingId + " has been deleted successfully.");
        } else {
            // If booking does not exist, handle the error
            throw new IllegalArgumentException("Booking with ID " + bookingId + " does not exist.");
        }
        return "success";
    }
}
