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
@Entity(name = "stylist")
public class Stylist {

    @SequenceGenerator(
            name = "stylist_sequence",
            sequenceName = "stylist_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "stylist_sequence"
    )
    @Id
    private Long id;

    private String name;

    private int price;

}
