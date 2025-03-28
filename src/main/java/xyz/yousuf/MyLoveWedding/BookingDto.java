package xyz.yousuf.MyLoveWedding;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookingDto {
    String name;
    String email;
    String phone;
    String venueId;
    String date;
    String lawyerId;
    String stylistId;
    String photographerId;


}
