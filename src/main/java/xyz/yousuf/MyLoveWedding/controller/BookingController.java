package xyz.yousuf.MyLoveWedding.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.yousuf.MyLoveWedding.BookingDto;
import xyz.yousuf.MyLoveWedding.entities.Booking;
import xyz.yousuf.MyLoveWedding.repository.BookingRepository;
import xyz.yousuf.MyLoveWedding.service.BookingService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @Autowired
    private BookingRepository bookingRepository;

    @GetMapping("/view")
    List<Booking> viewAllBookings(){
        List<Booking> allBookings =  bookingRepository.findAll();
        return allBookings;
    }

    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Booking> addBooking (@RequestBody BookingDto bookingDto){
        Booking booking = bookingService.addBooking(bookingDto);
        return ResponseEntity.ok(booking);
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<?> deleteBooking(@PathVariable Long id){

        try {
            bookingRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok(bookingRepository.findAll());
    }
}
