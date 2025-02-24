package xyz.yousuf.MyLoveWedding.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.yousuf.MyLoveWedding.entities.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
