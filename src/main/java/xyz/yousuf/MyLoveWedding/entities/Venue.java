package xyz.yousuf.MyLoveWedding.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "venue")
public class Venue {

    @SequenceGenerator(
            name = "venue_sequence",
            sequenceName = "venue_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "venue_sequence"
    )
    @Id
    private Long venueId;

    private String venueName;

    private String address;

    @ColumnDefault("false")
    private boolean isDelete;
}
