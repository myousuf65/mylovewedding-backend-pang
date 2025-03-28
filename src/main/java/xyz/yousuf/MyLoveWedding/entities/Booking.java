package xyz.yousuf.MyLoveWedding.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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

    @ManyToOne()
    @JoinColumn(name ="venue_id")
    private Venue venue;

    @ManyToOne
    @JoinColumn(name = "lawyer_id")
    private Lawyer lawyer;

    @ManyToOne
    @JoinColumn(name = "stylist_id")
    private Stylist stylist;

    @ManyToOne
    @JoinColumn(name = "photographer_id")
    private Photographer photographer;

    private String Date;

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", customer=" + customer +
                ", venue=" + venue +
                ", lawyer=" + lawyer +
                ", stylist=" + stylist +
                ", photographer=" + photographer +
                ", Date='" + Date + '\'' +
                '}';
    }
}
