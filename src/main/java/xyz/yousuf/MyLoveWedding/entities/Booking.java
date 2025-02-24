package xyz.yousuf.MyLoveWedding.entities;


import jakarta.persistence.*;

@Entity
@Table(name ="booking")
public class Booking {

    @SequenceGenerator(
            name = "booking_sequence",
            sequenceName = "booking_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "booking_sequence"
    )
    @Id
    private Long id;

    @ManyToOne()
    @JoinColumn(referencedColumnName = "id", name = "customer_id")
    private Customer customer;

    private String timing;

    @ManyToOne()
    @JoinColumn(name ="venue_id")
    private Venue venue;

    public Booking(){}
    public Booking(Long id, Customer customer, String timing, Venue venue) {
        this.id = id;
        this.customer = customer;
        this.timing = timing;
        this.venue = venue;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getTiming() {
        return timing;
    }

    public void setTiming(String timing) {
        this.timing = timing;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", customer=" + customer +
                ", timing='" + timing + '\'' +
                ", venue=" + venue +
                '}';
    }
}
