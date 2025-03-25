package xyz.yousuf.MyLoveWedding.dto;

public class AddVenue {
    private String venueName;
    private String venueAddress;

    public AddVenue(String venueName, String venueAddress) {
        this.venueName = venueName;
        this.venueAddress = venueAddress;
    }

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public String getVenueAddress() {
        return venueAddress;
    }

    public void setVenueAddress(String venueAddress) {
        this.venueAddress = venueAddress;
    }

    @Override
    public String toString() {
        return "AddVenue{" +
                "venueName='" + venueName + '\'' +
                ", venueAddress='" + venueAddress + '\'' +
                '}';
    }
}
