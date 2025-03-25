package xyz.yousuf.MyLoveWedding;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xyz.yousuf.MyLoveWedding.entities.Venue;
import xyz.yousuf.MyLoveWedding.repository.VenueRepository;

import java.util.List;

@Component
public class DatabaseInitializer {

    @Autowired
    private VenueRepository venueRepository;


    @PostConstruct
    public void init(){
        List<Venue> venues = venueRepository.findAll();

        if(venues.isEmpty()){

            Venue venue1 = new Venue();
            venue1.setVenueName("Stadium A");
            venue1.setAddress("1234 Main St, Springfield, IL");

            Venue venue2 = new Venue();
            venue2.setVenueName("Concert Hall B");
            venue2.setAddress("5678 Oak Ave, Chicago, IL");

            Venue venue3 = new Venue();
            venue3.setVenueName("Arena C");
            venue3.setAddress("1357 Pine Rd, Peoria, IL");

            Venue venue4 = new Venue();
            venue4.setVenueName("Theatre D");
            venue4.setAddress("2468 Elm St, Urbana, IL");

            Venue venue5 = new Venue();
            venue5.setVenueName("Conference Center E");
            venue5.setAddress("3690 Maple Ln, Champaign, IL");

            Venue venue6 = new Venue();
            venue6.setVenueName("Expo Hall F");
            venue6.setAddress("4821 Birch Blvd, Decatur, IL");

            Venue venue7 = new Venue();
            venue7.setVenueName("Sports Complex G");
            venue7.setAddress("5942 Cedar Dr, Bloomington, IL");

            Venue venue8 = new Venue();
            venue8.setVenueName("Music Venue H");
            venue8.setAddress("6073 Ashwood Blvd, Danville, IL");

            Venue venue9 = new Venue();
            venue9.setVenueName("Outdoor Park I");
            venue9.setAddress("7184 Redwood St, Carbondale, IL");

            Venue venue10 = new Venue();
            venue10.setVenueName("Cultural Center J");
            venue10.setAddress("8295 Willow Rd, Normal, IL");

            venueRepository.save(venue1);
            venueRepository.save(venue2);
            venueRepository.save(venue3);
            venueRepository.save(venue4);
            venueRepository.save(venue5);
            venueRepository.save(venue6);
            venueRepository.save(venue7);
            venueRepository.save(venue8);
            venueRepository.save(venue9);
            venueRepository.save(venue10);

        }else{
            System.out.println("venues table is not empty");
        }


    }


}
