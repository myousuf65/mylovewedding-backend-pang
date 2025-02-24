package xyz.yousuf.MyLoveWedding;

public class BookingDto {
    String name;
    String email;
    String phone;
    String timeslot;
    String venue;

    public BookingDto(String name, String email, String phone, String timeslot, String venue) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.timeslot = timeslot;
        this.venue = venue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTimeslot() {
        return timeslot;
    }

    public void setTimeslot(String timeslot) {
        this.timeslot = timeslot;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }
}
