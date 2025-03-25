package xyz.yousuf.MyLoveWedding.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.yousuf.MyLoveWedding.dto.AddVenue;
import xyz.yousuf.MyLoveWedding.entities.Venue;
import xyz.yousuf.MyLoveWedding.service.VenueService;
import java.util.List;
import org.springframework.stereotype.*;

// >>>will only serve REST content,cannot serve thymeleaf<<<
@RestController
@RequestMapping("/venue")
@CrossOrigin
public class VenueController {

    @Autowired
    private VenueService service;

    @GetMapping("/view")
    ResponseEntity<List<Venue>> getAllVenues(){
        List<Venue> all = service.getAllVenues();
        System.out.println("received request");
        return ResponseEntity.ok(all);
    }

    @PostMapping("/add")
    String addVenue(@RequestBody AddVenue venue){
        String result = service.addVenue(venue);
        return result;
    }

    @PostMapping("/modify")
    Venue modifyVenue(@RequestBody Venue venue){
        Venue ven = service.modifyVenue(venue);
        return ven;
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<?> deleteVenue(@PathVariable Long id){
        List<Venue> result = service.deleteVenue(id);
        return ResponseEntity.ok(result);
    }
}