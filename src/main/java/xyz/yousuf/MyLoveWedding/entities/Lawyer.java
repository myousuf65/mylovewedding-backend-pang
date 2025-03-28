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
@Entity(name = "lawyer")
public class Lawyer {

    @SequenceGenerator(
            name = "lawyer_sequence",
            sequenceName = "lawyer_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "lawyer_sequence"
    )
    @Id
    private Long id;

    private String name;

    private int price;

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
