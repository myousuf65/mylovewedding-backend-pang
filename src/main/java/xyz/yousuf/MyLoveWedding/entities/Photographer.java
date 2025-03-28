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
@Entity(name = "photographer")
public class Photographer {
    @SequenceGenerator(
            name = "photographer_sequence",
            sequenceName = "photographer_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "photographer_sequence"
    )
    @Id
    private Long id;

    private String name;

    private int price;

}
