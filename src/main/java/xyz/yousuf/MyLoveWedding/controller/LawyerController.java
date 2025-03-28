package xyz.yousuf.MyLoveWedding.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import xyz.yousuf.MyLoveWedding.entities.Lawyer;
import xyz.yousuf.MyLoveWedding.entities.Photographer;
import xyz.yousuf.MyLoveWedding.entities.Stylist;
import xyz.yousuf.MyLoveWedding.repository.LawyerRepository;
import xyz.yousuf.MyLoveWedding.repository.PhotographerRepository;
import xyz.yousuf.MyLoveWedding.repository.StylistRepository; // Import StylistRepository

@CrossOrigin
@RestController
public class LawyerController {

    private final LawyerRepository lawyerRepository;
    private final StylistRepository stylistRepository; // Corrected type
    private final PhotographerRepository photographerRepository;

    public LawyerController(
            LawyerRepository lawyerRepository,
            StylistRepository stylistRepository, // Corrected type
            PhotographerRepository photographerRepository) {
        this.lawyerRepository = lawyerRepository;
        this.stylistRepository = stylistRepository;
        this.photographerRepository = photographerRepository;
    }

    @GetMapping("/lawyer/view")
    ResponseEntity<?> getAllLawyers() {
        return ResponseEntity.ok(lawyerRepository.findAll());
    }

    @PostMapping("/lawyer/add")
    ResponseEntity<?> addLawyer(@RequestBody Lawyer lawyerDto) {
        Lawyer l = new Lawyer();
        l.setName(lawyerDto.getName());
        l.setPrice(lawyerDto.getPrice());

        Lawyer savedLawyer = lawyerRepository.save(l);
        lawyerRepository.flush();
        return ResponseEntity.ok(savedLawyer);
    }

    @PostMapping("/stylist/add")
    ResponseEntity<?> addStylist(@RequestBody Stylist stylistDto) { // Corrected method name and param type
        Stylist l = new Stylist();
        l.setName(stylistDto.getName());
        l.setPrice(stylistDto.getPrice());

        Stylist savedStylist = stylistRepository.save(l); // Corrected type
        stylistRepository.flush();
        return ResponseEntity.ok(savedStylist); // Corrected type
    }

    @PostMapping("/photographer/add")
    ResponseEntity<?> addPhotographer(@RequestBody Photographer photographerDto) { //Corrected parameter type
        Photographer l = new Photographer();
        l.setName(photographerDto.getName());
        l.setPrice(photographerDto.getPrice());

        Photographer savedPhotographer = photographerRepository.save(l);
        photographerRepository.flush();
        return ResponseEntity.ok(savedPhotographer);
    }

    @GetMapping("/stylist/view")
    ResponseEntity<?> getAllStylist() { //Corrected method name
        return ResponseEntity.ok(stylistRepository.findAll());
    }

    @GetMapping("/photographer/view")
    ResponseEntity<?> getAllPhotographer() {
        return ResponseEntity.ok(photographerRepository.findAll());
    }
}
