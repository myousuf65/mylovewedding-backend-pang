package xyz.yousuf.MyLoveWedding.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import xyz.yousuf.MyLoveWedding.dto.AddVenue;
import xyz.yousuf.MyLoveWedding.entities.Venue;
import xyz.yousuf.MyLoveWedding.repository.VenueRepository;

import java.util.List;
import java.util.Optional;

@Service
public class VenueService {

    @Autowired
    private VenueRepository repository;
    @Autowired
    private VenueRepository venueRepository;


    public  List<Venue> getAllVenues(){
        return repository.findByIsDeleteFalse();
    }

    public String addVenue(AddVenue venue) {
        Venue ven = new Venue();
        ven.setAddress(venue.getVenueAddress());
        ven.setVenueName(venue.getVenueName());

        repository.save(ven);
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

    public List<Venue> deleteVenue(Long id) {
        Venue venue = venueRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not Found"));

        venue.setDelete(true);

        venueRepository.save(venue);
        return venueRepository.findByIsDeleteFalse();
    }

//   @DeleteMapping("/venue/delete/")
//   ResponseEntity<?> deleteVenue()
}
